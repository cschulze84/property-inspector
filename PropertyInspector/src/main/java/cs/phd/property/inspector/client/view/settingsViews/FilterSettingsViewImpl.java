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
public class FilterSettingsViewImpl<T> extends Composite implements FilterSettingsView<T> {

	@UiTemplate("FilterSettingsView.ui.xml")
	interface FilterSettingsViewUiBinder extends UiBinder<Widget, FilterSettingsViewImpl> {
	}

	private static FilterSettingsViewUiBinder uiBinder = GWT.create(FilterSettingsViewUiBinder.class);
	
	private Presenter<T> presenter;

	public FilterSettingsViewImpl() {
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
