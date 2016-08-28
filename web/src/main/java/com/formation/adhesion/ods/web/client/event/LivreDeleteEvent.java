package com.formation.adhesion.ods.web.client.event;

import com.formation.adhesion.ods.core.model.Livre;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.view.client.SelectionChangeEvent;

public class LivreDeleteEvent extends
    GwtEvent<LivreDeleteEvent.Handler> {

	private Livre livre;
	
  /**
   * Handler interface for {@link SelectionChangeEvent} events.
   */
  public static interface Handler extends EventHandler {

    /**
     * Called when a {@link SelectionChangeEvent} is fired.
     *
     * @param event the {@link SelectionChangeEvent} that was fired
     */
    void onSelectionChange(LivreDeleteEvent event);
  }

  /**
   * Handler type.
   */
  public static Type<LivreDeleteEvent.Handler> TYPE = new  Type<LivreDeleteEvent.Handler>();



  /**
   * Gets the type associated with this event.
   *
   * @return returns the handler type
   */
  public static Type<LivreDeleteEvent.Handler> getType() {
    if (TYPE == null) {
      TYPE = new Type<LivreDeleteEvent.Handler>();
    }
    return TYPE;
  }

  /**
   * Creates a selection change event.
   */
  public LivreDeleteEvent(Livre livre) {
	  this.setLivre(livre);
  }

  @Override
  public final Type<LivreDeleteEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(LivreDeleteEvent.Handler handler) {
    handler.onSelectionChange(this);
  }

public void setLivre(Livre livre) {
	this.livre = livre;
}

public Livre getLivre() {
	return livre;
}
}

