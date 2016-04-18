package cs.phd.property.inspector.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowFileSettingsViewEvent extends GwtEvent<ShowFileSettingsViewEventHandler>{
	public static Type<ShowFileSettingsViewEventHandler> TYPE = new Type<ShowFileSettingsViewEventHandler>();
	
	  @Override
	  public Type<ShowFileSettingsViewEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowFileSettingsViewEventHandler handler) {
	    handler.onShowFileSettingsView(this);
	  }
}
