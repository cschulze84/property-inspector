package cs.phd.property.inspector.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

import cs.phd.property.inspector.client.InspectorServiceAsync;
import cs.phd.property.inspector.client.event.ShowAbstractionPropertiesViewEvent;
import cs.phd.property.inspector.client.event.ShowAbstractionSettingsViewEvent;
import cs.phd.property.inspector.client.event.ShowCommonPropertiesViewEvent;
import cs.phd.property.inspector.client.event.ShowDiffPropertiesViewEvent;
import cs.phd.property.inspector.client.event.ShowFileSettingsViewEvent;
import cs.phd.property.inspector.client.event.ShowFilterSettingsViewEvent;
import cs.phd.property.inspector.client.view.InspectorView;
import cs.phd.property.inspector.client.view.InspectorViewImpl;

public class InspectorPresenter implements Presenter, InspectorView.Presenter<String> {

	private final InspectorServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final InspectorView<String> view;

	public InspectorPresenter(InspectorServiceAsync rpcService, HandlerManager eventBus,
			InspectorViewImpl<String> view) {
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

	@Override
	public void onFileFieldClicked() {
		eventBus.fireEvent(new ShowFileSettingsViewEvent());
	}

	@Override
	public void onAbstractionFieldClicked() {
		eventBus.fireEvent(new ShowAbstractionSettingsViewEvent());
	}

	@Override
	public void onFilterFieldClicked() {
		eventBus.fireEvent(new ShowFilterSettingsViewEvent());
	}

	@Override
	public void onCommonTabClicked() {
		eventBus.fireEvent(new ShowCommonPropertiesViewEvent());
	}

	@Override
	public void onDiffTabClicked() {
		eventBus.fireEvent(new ShowDiffPropertiesViewEvent());
	}

	@Override
	public void onAbstractionTabClicked() {
		eventBus.fireEvent(new ShowAbstractionPropertiesViewEvent());
	}

}
