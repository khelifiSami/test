package com.formation.adhesion.ods.web.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;

public class LivreListEvent extends
    GwtEvent<LivreListEvent.Handler> {

  /**
   * Handler interface for {@link SelectionChangeEvent} events.
   */
  public static interface Handler extends EventHandler {

    /**
     * Called when a {@link SelectionChangeEvent} is fired.
     *
     * @param event the {@link SelectionChangeEvent} that was fired
     */
    void onSelectionChange(LivreListEvent event);
  }

  /**
   * Handler type.
   */
  public static Type<LivreListEvent.Handler> TYPE = new  Type<LivreListEvent.Handler>();

  /**
   * Fires a selection change event on all registered handlers in the handler
   * manager. If no such handlers exist, this method will do nothing.
   *
   * @param source the source of the handlers
   */
  public static void fire(SelectionModel<?> source) {
    if (TYPE != null) {
    	LivreListEvent event = new LivreListEvent();
      source.fireEvent(event);
    }
  }

  /**
   * Gets the type associated with this event.
   *
   * @return returns the handler type
   */
  public static Type<LivreListEvent.Handler> getType() {
    if (TYPE == null) {
      TYPE = new Type<LivreListEvent.Handler>();
    }
    return TYPE;
  }

  /**
   * Creates a selection change event.
   */
  public LivreListEvent() {
  }

  @Override
  public final Type<LivreListEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(LivreListEvent.Handler handler) {
    handler.onSelectionChange(this);
  }
}

