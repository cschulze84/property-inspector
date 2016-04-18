package cs.phd.property.inspector.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import cs.phd.property.inspector.client.InspectorServiceAsync;
import cs.phd.property.inspector.client.view.dataViews.DiffPropertiesView;
import cs.phd.property.inspector.client.view.dataViews.DiffPropertiesViewImpl;

public class DiffPropertiesPresenter implements Presenter, DiffPropertiesView.Presenter<String>{
	private final InspectorServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final DiffPropertiesView<String> view;
	
	public DiffPropertiesPresenter(InspectorServiceAsync rpcService, HandlerManager eventBus,
			DiffPropertiesViewImpl<String> view) {
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