package cs.phd.property.inspector.client.view.dataViews;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class DiffPropertiesViewImpl<T> extends Composite implements DiffPropertiesView<T> {

	@UiTemplate("DiffPropertiesView.ui.xml")
	interface DiffPropertiesViewUiBinder extends UiBinder<Widget, DiffPropertiesViewImpl> {
	}

	private static DiffPropertiesViewUiBinder uiBinder = GWT.create(DiffPropertiesViewUiBinder.class);
	
	private Presenter<T> presenter;

	public DiffPropertiesViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter<T> presenter) {
		this.presenter = presenter;
	}

	public Widget asWidget() {
		return this;
	}
}
