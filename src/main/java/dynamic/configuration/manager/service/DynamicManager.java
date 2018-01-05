package dynamic.configuration.manager.service;

public interface DynamicManager {

	/**
	 * Return instance of
	 * 
	 * @return
	 */
	public DynamicManager start();

	public <T> T getValue(String key);

}
