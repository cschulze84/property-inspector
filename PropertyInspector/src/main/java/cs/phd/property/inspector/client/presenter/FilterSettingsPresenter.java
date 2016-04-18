package cs.phd.property.inspector.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import cs.phd.property.inspector.client.InspectorServiceAsync;
import cs.phd.property.inspector.client.view.settingsViews.FilterSettingsView;
import cs.phd.property.inspector.client.view.settingsViews.FilterSettingsViewImpl;

public class FilterSettingsPresenter implements Presenter, FilterSettingsView.Presenter<String>{
	private final InspectorServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final FilterSettingsView<String> view;
	
	public FilterSettingsPresenter(InspectorServiceAsync rpcService, HandlerManager eventBus,
			FilterSettingsViewImpl<String> view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.view = view;
		this.view.setPresenter(this);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

}
