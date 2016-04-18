package cs.phd.property.inspector.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowAbstractionPropertiesViewEvent extends GwtEvent<ShowAbstractionPropertiesViewEventHandler>{
	public static Type<ShowAbstractionPropertiesViewEventHandler> TYPE = new Type<ShowAbstractionPropertiesViewEventHandler>();
	
	  @Override
	  public Type<ShowAbstractionPropertiesViewEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowAbstractionPropertiesViewEventHandler handler) {
	    handler.onShowAbstractionPropertiesView(this);
	  }
}