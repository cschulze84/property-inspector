package cs.phd.property.inspector.client.view.dataViews;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class AbstractionPropertiesViewImpl<T> extends Composite implements AbstractionPropertiesView<T> {

	@UiTemplate("AbstractionPropertiesView.ui.xml")
	interface AbstractionPropertiesViewUiBinder extends UiBinder<Widget, AbstractionPropertiesViewImpl> {
	}

	private static AbstractionPropertiesViewUiBinder uiBinder = GWT.create(AbstractionPropertiesViewUiBinder.class);
	
	private Presenter<T> presenter;

	public AbstractionPropertiesViewImpl() {
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
