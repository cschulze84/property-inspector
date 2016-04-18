/**
 * 
 */
package cs.phd.property.inspector.client.view.settingsViews;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Christoph
 *
 */
public class AbstractionSettingsViewImpl<T> extends Composite implements AbstractionSettingsView<T> {

	@UiTemplate("AbstractionSettingsView.ui.xml")
	interface AbstractionSettingsViewUiBinder extends UiBinder<Widget, AbstractionSettingsViewImpl> {
	}

	private static AbstractionSettingsViewUiBinder uiBinder = GWT.create(AbstractionSettingsViewUiBinder.class);
	
	private Presenter<T> presenter;

	public AbstractionSettingsViewImpl() {
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
