package cs.phd.property.inspector.client.view.dataViews;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class CommonPropertiesViewImpl<T> extends Composite implements CommonPropertiesView<T> {

	@UiTemplate("CommonPropertiesView.ui.xml")
	interface CommonPropertiesViewUiBinder extends UiBinder<Widget, CommonPropertiesViewImpl> {
	}

	private static CommonPropertiesViewUiBinder uiBinder = GWT.create(CommonPropertiesViewUiBinder.class);
	
	private Presenter<T> presenter;

	public CommonPropertiesViewImpl() {
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
