package cs.phd.property.inspector.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowDiffPropertiesViewEvent extends GwtEvent<ShowDiffPropertiesViewEventHandler>{
	public static Type<ShowDiffPropertiesViewEventHandler> TYPE = new Type<ShowDiffPropertiesViewEventHandler>();
	
	  @Override
	  public Type<ShowDiffPropertiesViewEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowDiffPropertiesViewEventHandler handler) {
	    handler.onShowDiffPropertiesView(this);
	  }
}