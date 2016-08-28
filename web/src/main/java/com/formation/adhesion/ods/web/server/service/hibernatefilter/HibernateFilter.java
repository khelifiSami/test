/*
 * Copyright 2008 Jeff Dwyer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.formation.adhesion.ods.web.server.service.hibernatefilter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.collection.PersistentBag;
import org.hibernate.collection.PersistentList;
import org.hibernate.collection.PersistentMap;
import org.hibernate.collection.PersistentSet;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;

public class HibernateFilter {
	private static final Logger log = Logger.getLogger(HibernateFilter.class);

	@SuppressWarnings("unchecked")
	public static Object filter(Object input) {
		try {
			RPC.getDefaultSerializationPolicy().validateSerialize(input.getClass());
			return input;
		} catch (SerializationException e1) {

			if (input == null) {
				return input;
			}
			if (input instanceof Date) {
				return new java.util.Date(((java.util.Date) input).getTime());
			}

			if (input instanceof PersistentSet) {
				HashSet<Object> hashSet = new HashSet<Object>();
				PersistentSet persSet = (PersistentSet) input;
				if (persSet.wasInitialized()) {
					addAll(persSet, hashSet);
				}
				return hashSet;
			}
			if (input instanceof PersistentList) {
				ArrayList<Object> arrayList = new ArrayList<Object>();
				PersistentList persList = (PersistentList) input;
				if (persList.wasInitialized()) {
					addAll(persList, arrayList);
				}
				return arrayList;
			}
			if (input instanceof PersistentBag) {
				ArrayList<Object> arrayList = new ArrayList<Object>();
				PersistentBag persBag = (PersistentBag) input;
				if (persBag.wasInitialized()) {
					addAll(persBag, arrayList);
				}
				return arrayList;
			}
			if (input instanceof PersistentMap) {
				HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
				PersistentMap persMap = (PersistentMap) input;
				if (persMap.wasInitialized()) {
					putAll(persMap, hashMap);
				}
				return hashMap;
			}
			if (input.getClass().getName().contains("CGLIB")) {

				if (Hibernate.isInitialized(input)) {

					try {
						HibernateProxy hp = (HibernateProxy) input;
						LazyInitializer li = hp.getHibernateLazyInitializer();
						log.warn("On The Fly initialization: "
								+ li.getEntityName());
						return li.getImplementation();

					} catch (ClassCastException c) {
						log.error("error casting to HibernateProxy " + input);
						return null;
					}

					// Hibernate.initialize(instance);
					//
					//
					// log.warn("\nentity: " + cg.getEntityName()
					// + "\nidentifier" + cg.getIdentifier()
					// + "\nimplemenation " + cg.getImplementation());
					//
					// log.warn("On The Fly initialization: " + instance
					// + " now: " + instance.getClass().getName());
					//
					// if (instance instanceof ReallyCloneable) {
					// log.debug(instance.getClass().getName()
					// + " CGLIB Cloning " + instance);
					// return ((ReallyCloneable) instance).clone();
					// } else {
					// log
					// .warn("Initialized, but doesn't implement
					// ReallyCloneable"
					// + instance.getClass()
					// + " "
					// + instance.getClass().getName());
					// throw new CouldntFixCGLIBException(
					// instance.getClass()
					// + " must implement ReallyCloneable if we're to fix
					// it.");
					// }
				} else {
					log.debug("Uninitialized CGLIB");
					return null;
				}
			}

			Class instanceClass = input.getClass();
			Method[] methods = instanceClass.getMethods();
			for (int i = 0; i < methods.length; i++) {
				try {
					if (methods[i].getName().startsWith("get")) {
						Object value = methods[i].invoke(input);

						// on doit donc filtrer cette valeur
						Method setter = null;
						try {
							setter = instanceClass.getMethod("s"
									+ methods[i].getName().substring(1),
									methods[i].getReturnType());

						} catch (Exception e) {
							// la methode set correspondante n'existe pas
						}
						if (setter != null)
							setter.invoke(input, filter(value));

					}
				} catch (InvocationTargetException e) {
					log.info("Call method " + methods[i].getName()
							+ " failed on class " + instanceClass.getName());
					} catch (Exception e) {
					log.error(e);
				}
			}
			return input;
		}

	}

	public static void addAll(PersistentSet c, HashSet hs) {

		boolean modified = false;
		Iterator e = c.iterator();
		while (e.hasNext()) {
			if (hs.add(filter(e.next())))
				modified = true;
		}
	}

	public static void addAll(PersistentList pl, ArrayList al) {
		Object[] a = pl.toArray();
		for (int i = 0; i < a.length; i++) {
			al.add(filter(a[i]));
		}

	}

	public static void addAll(PersistentBag pb, ArrayList al) {
		Object[] a = pb.toArray();
		for (int i = 0; i < a.length; i++) {
			al.add(filter(a[i]));
		}

	}

	public static void putAll(PersistentMap pm, HashMap hm) {
		Set<Object> keys = pm.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			Object key = (Object) iterator.next();
			hm.put(key, filter(pm.get(key)));
		}
	}
}
