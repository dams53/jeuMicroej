package __jeuJPIMPEDGO__.generated;

import ej.wadapps.management.ActivitiesList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleActivator;

public class JeuJPIMPEDGOActivator implements BundleActivator {

	microej.lab.MyActivity microej__lab__MyActivity;

	@Override
	public void initialize() {
		this.microej__lab__MyActivity = new microej.lab.MyActivity();
	}

	@Override
	public void link() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.add(this.microej__lab__MyActivity);

	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.remove(this.microej__lab__MyActivity);

	}

}