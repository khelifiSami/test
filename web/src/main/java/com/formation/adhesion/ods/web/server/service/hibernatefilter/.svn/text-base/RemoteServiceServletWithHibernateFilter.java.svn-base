package com.formation.adhesion.ods.web.server.service.hibernatefilter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.AbstractSerializationStream;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.SerializationPolicy;
import com.google.gwt.user.server.rpc.UnexpectedException;

public class RemoteServiceServletWithHibernateFilter extends
		RemoteServiceServlet {
	/**
	 * The implementation of the service.
	 */
	private final Object delegate;

	public RemoteServiceServletWithHibernateFilter() {
		this.delegate = this;
	}

	@Override
	public String processCall(String payload) throws SerializationException {
		

		// First, check for possible XSRF situation
		checkPermutationStrongName();

		try {
			RPCRequest rpcRequest = RPC.decodeRequest(payload,
					delegate.getClass(), this);
			onAfterRequestDeserialized(rpcRequest);
			return invokeAndEncodeResponse(delegate,
					rpcRequest.getMethod(), rpcRequest.getParameters(),
					rpcRequest.getSerializationPolicy(), rpcRequest.getFlags());
		} catch (IncompatibleRemoteServiceException ex) {
			log("An IncompatibleRemoteServiceException was thrown while processing this call.",
					ex);
			return RPC.encodeResponseForFailure(null, ex);
		} catch (RpcTokenException tokenException) {
			log("An RpcTokenException was thrown while processing this call.",
					tokenException);
			return RPC.encodeResponseForFailure(null, tokenException);
		}
	}
	
	  /**
	   * Returns a string that encodes the result of calling a service method, which
	   * could be the value returned by the method or an exception thrown by it.
	   * 
	   * <p>
	   * If the serializationPolicy parameter is not <code>null</code>, it is used
	   * to determine what types can be encoded as part of this response. If this
	   * parameter is <code>null</code>, then only subtypes of
	   * {@link com.google.gwt.user.client.rpc.IsSerializable IsSerializable} or
	   * types which have custom field serializers may be encoded.
	   * </p>
	   * 
	   * <p>
	   * This method does no security checking; security checking must be done on
	   * the method prior to this invocation.
	   * </p>
	   * 
	   * @param target instance on which to invoke the serviceMethod
	   * @param serviceMethod the method to invoke
	   * @param args arguments used for the method invocation
	   * @param serializationPolicy determines the serialization policy to be used
	   * @return a string which encodes either the method's return or a checked
	   *         exception thrown by the method
	   * 
	   * @throws NullPointerException if the serviceMethod or the
	   *           serializationPolicy are <code>null</code>
	   * @throws SecurityException if the method cannot be accessed or if the number
	   *           or type of actual and formal arguments differ
	   * @throws SerializationException if an object could not be serialized by the
	   *           stream
	   * @throws UnexpectedException if the serviceMethod throws a checked exception
	   *           that is not declared in its signature
	   */
	  public static String invokeAndEncodeResponse(Object target,
	      Method serviceMethod, Object[] args,
	      SerializationPolicy serializationPolicy) throws SerializationException {
	    return invokeAndEncodeResponse(target, serviceMethod, args,
	        serializationPolicy, AbstractSerializationStream.DEFAULT_FLAGS);
	  }

	  public static String invokeAndEncodeResponse(Object target,
	      Method serviceMethod, Object[] args,
	      SerializationPolicy serializationPolicy, int flags)
	      throws SerializationException {

	    if (serviceMethod == null) {
	      throw new NullPointerException("serviceMethod");
	    }

	    if (serializationPolicy == null) {
	      throw new NullPointerException("serializationPolicy");
	    }

	    String responsePayload;
	    try {
	      Object result = serviceMethod.invoke(target, args);

	      result = HibernateFilter.filter(result);
	     
	      responsePayload = RPC.encodeResponseForSuccess(serviceMethod, result,
	          serializationPolicy, flags);
	    } catch (IllegalAccessException e) {
	      SecurityException securityException = new SecurityException(
	    		  RPC.encodeResponseForFailure(serviceMethod, e));
	      securityException.initCause(e);
	      throw securityException;
	    } catch (IllegalArgumentException e) {
	      SecurityException securityException = new SecurityException(
	    		  RPC.encodeResponseForFailure(serviceMethod, e));
	      securityException.initCause(e);
	      throw securityException;
	    } catch (InvocationTargetException e) {
	      // Try to encode the caught exception
	      //
	      Throwable cause = e.getCause();

	      responsePayload = RPC.encodeResponseForFailure(serviceMethod, cause,
	          serializationPolicy, flags);
	    }

	    return responsePayload;
	  }
}
