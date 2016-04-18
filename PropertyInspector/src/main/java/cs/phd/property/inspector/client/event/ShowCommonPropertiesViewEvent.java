package cs.phd.property.inspector.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowCommonPropertiesViewEvent extends GwtEvent<ShowCommonPropertiesViewEventHandler>{
	public static Type<ShowCommonPropertiesViewEventHandler> TYPE = new Type<ShowCommonPropertiesViewEventHandler>();
	
	  @Override
	  public Type<ShowCommonPropertiesViewEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowCommonPropertiesViewEventHandler handler) {
	    handler.onShowCommonPropertiesView(this);
	  }
}