package cs.phd.property.inspector.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import cs.phd.property.inspector.client.InspectorServiceAsync;
import cs.phd.property.inspector.client.view.settingsViews.FilesSettingsView;
import cs.phd.property.inspector.client.view.settingsViews.FilesSettingsViewImpl;

public class FilesSettingsPresenter implements Presenter, FilesSettingsView.Presenter<String>{
	private final InspectorServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final FilesSettingsView<String> view;
	
	public FilesSettingsPresenter(InspectorServiceAsync rpcService, HandlerManager eventBus,
			FilesSettingsViewImpl<String> view) {
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
