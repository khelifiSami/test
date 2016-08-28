package com.formation.clientbundle.client;

import com.formation.clientbundle.client.resource.css.ActivableCssRessource;
import com.formation.clientbundle.client.resource.css.BoutonCssRessource;
import com.formation.clientbundle.client.resource.css.CheckBoxCssRessource;
import com.formation.clientbundle.client.resource.css.MyCssBundle;
import com.formation.clientbundle.client.resource.css.MyCssResource;
import com.formation.clientbundle.client.resource.css.SharedScopeCssRessourceBundle;
import com.formation.clientbundle.client.resource.gwtcreate.Commande;
import com.formation.clientbundle.client.resource.gwtcreate.GwtCreateResourceBundle;
import com.formation.clientbundle.client.resource.image.ImageRessourceBundle;
import com.formation.clientbundle.client.resource.pdf.PDFResource;
import com.formation.clientbundle.client.resource.texte.TextResourceBundle;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClientBundle implements EntryPoint {

	@Override
	public void onModuleLoad() {
		VerticalPanel fp = new VerticalPanel();


		fp.add(buildTextRessource());
		fp.add(buildPdfRessource());
		fp.add(buildImageRessource());
		fp.add(buildGwtResourceBundle());
		fp.add(buildCssResourceBundle());

		RootPanel.get().add(fp);

	}

	/** Permet la mise en cache de fichier pdf */
	private Widget buildPdfRessource() {
		final FlowPanel fp = new FlowPanel();
		Frame f = new Frame(PDFResource.INSTANCE.yes().getUrl());
		f.setSize("400px", "400px");
		f.setVisible(true);
		fp.add(f);

		DisclosurePanel disclosure = new DisclosurePanel("PdfResource Exemple");
		disclosure.setAnimationEnabled(true);
		disclosure.setContent(fp);

		return disclosure;
	}

	/** Permet la mise en cache de fichier texte */
	private Widget buildTextRessource() {
		FlowPanel fp = new FlowPanel();
		TextArea ta = new TextArea();
		ta.setText(TextResourceBundle.INSTANCE.getASynchrone().getText());
		fp.add(ta);

		final TextArea ta2 = new TextArea();
		fp.add(ta2);
		try {
			TextResourceBundle.INSTANCE.getBAsynchrone().getText(
					new ResourceCallback<TextResource>() {
						public void onError(ResourceException e) {
						}

						public void onSuccess(TextResource r) {
							ta2.setText(r.getText());
						}
					});
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DisclosurePanel disclosure = new DisclosurePanel("TextResource Exemple");
		disclosure.setAnimationEnabled(true);
		disclosure.setContent(fp);

		return disclosure;
	}

	/** Permet la mise en cache des images */
	private Widget buildImageRessource() {
		FlowPanel fp = new FlowPanel();
		PushButton bImageA = new PushButton(new Image(ImageRessourceBundle.INSTANCE.imageA()));
		fp.add(bImageA);
		PushButton bImageB = new PushButton(new Image(ImageRessourceBundle.INSTANCE.imageB()));
		fp.add(bImageB);

		DisclosurePanel disclosure = new DisclosurePanel(
				"ImageResource Exemple");
		disclosure.setAnimationEnabled(true);
		disclosure.setContent(fp);

		return disclosure;
	}

	/**
	 * Permet d'acceder d'instancier une classe comme n'importe quelle ressource
	 */
	private Widget buildGwtResourceBundle() {
		FlowPanel fp = new FlowPanel();
		Commande obj = GwtCreateResourceBundle.INSTANCE.creerCommandeNumero1()
				.create();

		Label l = new Label(obj.executer("yes"));
		fp.add(l);

		DisclosurePanel disclosure = new DisclosurePanel("GwtResource Exemple");
		disclosure.setAnimationEnabled(true);
		disclosure.setContent(fp);
		// TODO Auto-generated method stub
		return disclosure;
	}

	/** Manipulation des css par ClientBundle */
	private Widget buildCssResourceBundle() {

		// lance le chargement en cache de la css
		// cette méthode sans effet si déjà chargé
		MyCssBundle.INSTANCE.myCss().ensureInjected();

		MyCssResource myCssResource = MyCssBundle.INSTANCE.myCss();

		VerticalPanel fp = new VerticalPanel();
		fp.setSpacing(10);

		// récuperation d'une valeur définie dans la css
		Label l = new Label(
				"Valeur de la constante small déclaré dans la MyCss :"
						+ myCssResource.small());
		fp.add(l);

		// permet de specifier le styleName par programmation
		// avec l'annotation @ClassName("mb") voir MyCssResource
		Button b = new Button(
				"Bouton avec style renvoyé par la méthode monButtonClass");
		b.setStyleName(myCssResource.mbClass());
		fp.add(b);

		// permet de spécifier des caractéristique d'un style par retour de
		// méthode java
		// on passe d'un model déclaratif à un model programmatic
		Button b2 = new Button(
				"Bouton utilisant PreferenceUtilisateur.getFontColor");
		b2.setStyleName(myCssResource.mb2Class());
		fp.add(b2);

		// Le retour d'une méthode d'un objet du client bundle sert de propriété
		// pour le style mb3
		Button b3 = new Button(
				"Bouton avec border-with = MyCssBundle.iconSmile.getWidth");
		b3.setStyleName(myCssResource.mb3());
		fp.add(b3);

		// Le retour d'une méthode d'un objet du client bundle sert de propriété
		// pour le style mb3
		Button b4 = new Button(
				"Bouton avec styleName mb4 conditionné par booleen");
		b4.setStyleName(myCssResource.mb4());
		fp.add(b4);

		// Le retour d'une méthode d'un objet du client bundle sert de propriété
		// pour le style mb3
		Button b5 = new Button("Bouton style change en fonction du navigateur");
		b5.setStyleName(myCssResource.mb5Class());
		fp.add(b5);

		// Uilisation d'une image renvoyée par un client à travers une css
		// Cette image est donc un parametre que l'on peut changer par
		// programmation
		Button b6 = new Button("Bouton image renvoyée par clientBundle");
		b6.setStyleName(myCssResource.mb6Class());
		fp.add(b6);

		// Concepts avancés
		SharedScopesExemple(fp);

		DisclosurePanel disclosure = new DisclosurePanel("CssResource Exemple");
		disclosure.setAnimationEnabled(true);
		disclosure.setContent(fp);
		// TODO Auto-generated method stub
		return disclosure;
	}

	private void SharedScopesExemple(VerticalPanel fp) {
		// Exemple de Shared Scopes
		// Les Shared Scores permettent de declarer la methode d'acces a un
		// style
		// qu'une seule fois alors alors
		// qu' il est présent dans plusieurs CSS
		// ici, 'activer' et 'desactiver' sont présent dans checkBoxCss.css et
		// boutonCss.css
		// comme CheckBoxCssRessource et BoutonCssRessource herite de
		// ActivableCssRessource
		// il suffit de déclarer dans ActivableCssRessource une seule fois
		// activer() et desactiver()

		SharedScopeCssRessourceBundle.INSTANCE.boutonCss().ensureInjected();
		SharedScopeCssRessourceBundle.INSTANCE.checkBoxCss().ensureInjected();
		BoutonCssRessource bcr = SharedScopeCssRessourceBundle.INSTANCE
				.boutonCss();
		ActivableCssRessource acr = SharedScopeCssRessourceBundle.INSTANCE
				.sharedCss();
		CheckBoxCssRessource cbcr = SharedScopeCssRessourceBundle.INSTANCE
				.checkBoxCss();

		Button b7 = new Button("Bouton activé");
		b7.setStyleName(bcr.composantStyle());
		b7.addStyleName(acr.activer());
		fp.add(b7);

		Button b8 = new Button("Bouton désactivé");
		b8.setStyleName(bcr.composantStyle());
		b8.addStyleName(acr.desactiver());
		fp.add(b8);

		CheckBox cb1 = new CheckBox("Checkbox activé");
		cb1.setStyleName(cbcr.composantStyle());
		cb1.addStyleName(acr.activer());
		fp.add(cb1);

		CheckBox cb2 = new CheckBox("Checkbox désactivé");
		cb2.setStyleName(cbcr.composantStyle());
		cb2.addStyleName(acr.desactiver());
		fp.add(cb2);
	}

}
