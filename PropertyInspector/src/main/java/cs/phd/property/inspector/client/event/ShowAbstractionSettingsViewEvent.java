package cs.phd.property.inspector.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowAbstractionSettingsViewEvent extends GwtEvent<ShowAbstractionSettingsViewEventHandler>{
	public static Type<ShowAbstractionSettingsViewEventHandler> TYPE = new Type<ShowAbstractionSettingsViewEventHandler>();
	
	  @Override
	  public Type<ShowAbstractionSettingsViewEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowAbstractionSettingsViewEventHandler handler) {
	    handler.onShowAbstractionSettingsView(this);
	  }
}
