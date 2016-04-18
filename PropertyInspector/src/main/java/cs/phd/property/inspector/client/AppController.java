package cs.phd.property.inspector.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import cs.phd.property.inspector.client.event.ShowAbstractionPropertiesViewEvent;
import cs.phd.property.inspector.client.event.ShowAbstractionPropertiesViewEventHandler;
import cs.phd.property.inspector.client.event.ShowAbstractionSettingsViewEvent;
import cs.phd.property.inspector.client.event.ShowAbstractionSettingsViewEventHandler;
import cs.phd.property.inspector.client.event.ShowCommonPropertiesViewEvent;
import cs.phd.property.inspector.client.event.ShowCommonPropertiesViewEventHandler;
import cs.phd.property.inspector.client.event.ShowDiffPropertiesViewEvent;
import cs.phd.property.inspector.client.event.ShowDiffPropertiesViewEventHandler;
import cs.phd.property.inspector.client.event.ShowFileSettingsViewEvent;
import cs.phd.property.inspector.client.event.ShowFileSettingsViewEventHandler;
import cs.phd.property.inspector.client.event.ShowFilterSettingsViewEvent;
import cs.phd.property.inspector.client.event.ShowFilterSettingsViewEventHandler;
import cs.phd.property.inspector.client.presenter.AbstractionSettingsPresenter;
import cs.phd.property.inspector.client.presenter.AbstractionPropertiesPresenter;
import cs.phd.property.inspector.client.presenter.CommonPropertiesPresenter;
import cs.phd.property.inspector.client.presenter.DiffPropertiesPresenter;
import cs.phd.property.inspector.client.presenter.FilesSettingsPresenter;
import cs.phd.property.inspector.client.presenter.FilterSettingsPresenter;
import cs.phd.property.inspector.client.presenter.InspectorPresenter;
import cs.phd.property.inspector.client.presenter.Presenter;
import cs.phd.property.inspector.client.view.InspectorViewImpl;
import cs.phd.property.inspector.client.view.dataViews.AbstractionPropertiesViewImpl;
import cs.phd.property.inspector.client.view.dataViews.CommonPropertiesViewImpl;
import cs.phd.property.inspector.client.view.dataViews.DiffPropertiesViewImpl;
import cs.phd.property.inspector.client.view.settingsViews.AbstractionSettingsViewImpl;
import cs.phd.property.inspector.client.view.settingsViews.FilesSettingsViewImpl;
import cs.phd.property.inspector.client.view.settingsViews.FilterSettingsViewImpl;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final InspectorServiceAsync rpcService;
	private HasWidgets container;
	private InspectorViewImpl<String> inspectorView = null;
	private FilterSettingsViewImpl<String> filterSettingsView;
	protected FilterSettingsPresenter filterSettingsPresenter;
	protected CommonPropertiesViewImpl<String> commonPropertiesView;
	protected CommonPropertiesPresenter commonPropertiesPresenter;
	protected DiffPropertiesViewImpl<String> diffPropertiesView;
	protected DiffPropertiesPresenter diffPropertiesPresenter;
	protected AbstractionPropertiesViewImpl<String> abstractionPropertiesView;
	protected AbstractionPropertiesPresenter abstractionPropertiesPresenter;
	protected FilesSettingsViewImpl<String> fileSettingsView;
	protected FilesSettingsPresenter fileSettingsPresenter;
	protected AbstractionSettingsViewImpl<String> abstractionSettingsView;
	protected AbstractionSettingsPresenter abstractionSettingsPresenter;

	public AppController(InspectorServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(ShowFilterSettingsViewEvent.TYPE, new ShowFilterSettingsViewEventHandler() {
			@Override
			public void onShowFilterView(ShowFilterSettingsViewEvent event) {
				doShowFilterView();
			}
		});
		
		eventBus.addHandler(ShowFileSettingsViewEvent.TYPE, new ShowFileSettingsViewEventHandler() {
			@Override
			public void onShowFileSettingsView(ShowFileSettingsViewEvent event) {
				doShowFileSettingsView();
			}
		});
		
		eventBus.addHandler(ShowAbstractionSettingsViewEvent.TYPE, new ShowAbstractionSettingsViewEventHandler() {
			@Override
			public void onShowAbstractionSettingsView(ShowAbstractionSettingsViewEvent event) {
				doShowAbstractionSettingsView();
			}
		});

		eventBus.addHandler(ShowCommonPropertiesViewEvent.TYPE, new ShowCommonPropertiesViewEventHandler() {
			@Override
			public void onShowCommonPropertiesView(ShowCommonPropertiesViewEvent event) {
				doShowCommonPropertiesView();
			}
		});
		
		eventBus.addHandler(ShowDiffPropertiesViewEvent.TYPE, new ShowDiffPropertiesViewEventHandler() {
			@Override
			public void onShowDiffPropertiesView(ShowDiffPropertiesViewEvent event) {
				doShowDiffPropertiesView();
			}
		});
		
		eventBus.addHandler(ShowAbstractionPropertiesViewEvent.TYPE, new ShowAbstractionPropertiesViewEventHandler() {
			@Override
			public void onShowAbstractionPropertiesView(ShowAbstractionPropertiesViewEvent event) {
				doShowAbstractionPropertiesView();
			}
		});

	}

	protected void doShowAbstractionPropertiesView() {
		History.newItem("abstractionView");
	}

	protected void doShowDiffPropertiesView() {
		History.newItem("diffView");
	}

	protected void doShowCommonPropertiesView() {
		History.newItem("commonView");
	}

	protected void doShowFilterView() {
		History.newItem("filterSettings");
	}
	
	protected void doShowFileSettingsView() {
		History.newItem("fileSettings");
	}
	
	protected void doShowAbstractionSettingsView() {
		History.newItem("abstractionSettings");
	}


	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			if (token.equals("start")) {
				GWT.runAsync(new RunAsyncCallback() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						// lazily initialize our views, and keep them around to
						// be reused
						//
						if (inspectorView == null) {
							inspectorView = new InspectorViewImpl<String>();

						}
						new InspectorPresenter(rpcService, eventBus, inspectorView).go(container);
					}
				});
			} else if (token.equals("filterSettings")) {
				GWT.runAsync(new RunAsyncCallback() {

					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						// lazily initialize our views, and keep them around to
						// be reused
						//
						if (filterSettingsView == null) {
							filterSettingsView = new FilterSettingsViewImpl<String>();

						}
						if (filterSettingsPresenter == null) {
							filterSettingsPresenter = new FilterSettingsPresenter(rpcService, eventBus, filterSettingsView);
							filterSettingsPresenter.go(inspectorView.getFilterSettingsMenuWidget());
						}
						inspectorView.switchToFilterSettingsView();
					}
				});
			}
			 else if (token.equals("fileSettings")) {
					GWT.runAsync(new RunAsyncCallback() {

						public void onFailure(Throwable caught) {
						}

						public void onSuccess() {
							// lazily initialize our views, and keep them around to
							// be reused
							//
							if (fileSettingsView == null) {
								fileSettingsView = new FilesSettingsViewImpl<String>();

							}
							if (fileSettingsPresenter == null) {
								fileSettingsPresenter = new FilesSettingsPresenter(rpcService, eventBus, fileSettingsView);
								fileSettingsPresenter.go(inspectorView.getFileSettingsMenuWidget());
							}
							inspectorView.switchToFileSettingsView();
						}
					});
				}
			 else if (token.equals("abstractionSettings")) {
					GWT.runAsync(new RunAsyncCallback() {

						public void onFailure(Throwable caught) {
						}

						public void onSuccess() {
							// lazily initialize our views, and keep them around to
							// be reused
							//
							if (abstractionSettingsView == null) {
								abstractionSettingsView = new AbstractionSettingsViewImpl<String>();

							}
							if (abstractionSettingsPresenter == null) {
								abstractionSettingsPresenter = new AbstractionSettingsPresenter(rpcService, eventBus, abstractionSettingsView);
								abstractionSettingsPresenter.go(inspectorView.getAbstractionSettingsMenuWidget());
							}
							inspectorView.switchToAbstractionSettingsView();
						}
					});
				}
			else if (token.equals("commonView")) {
				GWT.runAsync(new RunAsyncCallback() {

					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						// lazily initialize our views, and keep them around to
						// be reused
						//
						if (commonPropertiesView == null) {
							commonPropertiesView = new CommonPropertiesViewImpl<String>();

						}
						if (commonPropertiesPresenter == null) {
							commonPropertiesPresenter = new CommonPropertiesPresenter(rpcService, eventBus, commonPropertiesView);
							commonPropertiesPresenter.go(inspectorView.getCommonPropertiesWidget());
						}
						inspectorView.switchToCommonPropertiesView();
					}
				});
			}
			
			else if (token.equals("diffView")) {
				GWT.runAsync(new RunAsyncCallback() {

					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						// lazily initialize our views, and keep them around to
						// be reused
						//
						if (diffPropertiesView == null) {
							diffPropertiesView = new DiffPropertiesViewImpl<String>();

						}
						if (diffPropertiesPresenter == null) {
							diffPropertiesPresenter = new DiffPropertiesPresenter(rpcService, eventBus, diffPropertiesView);
							diffPropertiesPresenter.go(inspectorView.getDiffPropertiesWidget());
						}
						inspectorView.switchToDiffPropertiesView();
					}
				});
			}
			
			else if (token.equals("abstractionView")) {
				GWT.runAsync(new RunAsyncCallback() {

					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						// lazily initialize our views, and keep them around to
						// be reused
						//
						if (abstractionPropertiesView == null) {
							abstractionPropertiesView = new AbstractionPropertiesViewImpl<String>();

						}
						if (abstractionPropertiesPresenter == null) {
							abstractionPropertiesPresenter = new AbstractionPropertiesPresenter(rpcService, eventBus, abstractionPropertiesView);
							abstractionPropertiesPresenter.go(inspectorView.getAbstractionPropertiesWidget());
						}
						inspectorView.switchToAbstractionPropertiesView();
					}
				});
			}

		}
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		Window.setMargin("0px");
		Window.setTitle("Property Inspector");

		if ("".equals(History.getToken())) {
			History.newItem("start");
		} else {
			History.fireCurrentHistoryState();
		}
	}
}
