package cs.phd.property.inspector.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowFilterSettingsViewEvent extends GwtEvent<ShowFilterSettingsViewEventHandler>{
	public static Type<ShowFilterSettingsViewEventHandler> TYPE = new Type<ShowFilterSettingsViewEventHandler>();
	
	  @Override
	  public Type<ShowFilterSettingsViewEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowFilterSettingsViewEventHandler handler) {
	    handler.onShowFilterView(this);
	  }
}
