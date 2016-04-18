package cs.phd.property.inspector.client.view;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public interface InspectorView<T> {

	public interface Presenter<T> {
		void onFileFieldClicked();

		void onAbstractionFieldClicked();

		void onFilterFieldClicked();

		void onCommonTabClicked();

		void onDiffTabClicked();

		void onAbstractionTabClicked();
	}

	void setPresenter(Presenter<T> presenter);

	HasWidgets getFilterSettingsMenuWidget();

	Widget asWidget();

	HasWidgets getCommonPropertiesWidget();

	HasWidgets getDiffPropertiesWidget();

	HasWidgets getAbstractionPropertiesWidget();

	HasWidgets getFileSettingsMenuWidget();

	HasWidgets getAbstractionSettingsMenuWidget();
}
