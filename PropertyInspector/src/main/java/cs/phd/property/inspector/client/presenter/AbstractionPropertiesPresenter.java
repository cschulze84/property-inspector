package cs.phd.property.inspector.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import cs.phd.property.inspector.client.InspectorServiceAsync;
import cs.phd.property.inspector.client.view.dataViews.AbstractionPropertiesView;
import cs.phd.property.inspector.client.view.dataViews.AbstractionPropertiesViewImpl;
import cs.phd.property.inspector.client.view.dataViews.CommonPropertiesView;
import cs.phd.property.inspector.client.view.dataViews.CommonPropertiesViewImpl;
import cs.phd.property.inspector.client.view.settingsViews.AbstractionSettingsView;
import cs.phd.property.inspector.client.view.settingsViews.AbstractionSettingsViewImpl;

public class AbstractionPropertiesPresenter implements Presenter, AbstractionPropertiesView.Presenter<String>{
	private final InspectorServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final AbstractionPropertiesView<String> view;
	
	public AbstractionPropertiesPresenter(InspectorServiceAsync rpcService, HandlerManager eventBus,
			AbstractionPropertiesViewImpl<String> view) {
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