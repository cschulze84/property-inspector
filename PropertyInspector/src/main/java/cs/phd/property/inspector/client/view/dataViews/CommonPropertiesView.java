package cs.phd.property.inspector.client.view.dataViews;

import com.google.gwt.user.client.ui.Widget;

public interface CommonPropertiesView<T> {
	public interface Presenter<T> {
	}

	void setPresenter(Presenter<T> presenter);

	Widget asWidget();
}