package cs.phd.property.inspector.client.view.settingsViews;

import com.google.gwt.user.client.ui.Widget;

public interface AbstractionSettingsView<T> {
	public interface Presenter<T> {
	}

	void setPresenter(Presenter<T> presenter);

	Widget asWidget();
}
