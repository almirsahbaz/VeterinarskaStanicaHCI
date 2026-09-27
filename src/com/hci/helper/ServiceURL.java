package com.hci.helper;

public class ServiceURL
{
	private static final String webServiceUrl = "http://hci001.app.fit.ba/hci_ISVS/";
	public static final String service_loginURL = ServiceURL.webServiceUrl + "/service_login.php";
	public static final String service_VlasniciInsertURL = ServiceURL.webServiceUrl + "/VlasniciInsert.php";
	public static final String service_LijekoviGetURL = ServiceURL.webServiceUrl + "/VratiLijekove.php";
	public static final String service_DijagnozeGetURL = ServiceURL.webServiceUrl + "/VratiDijagnoze.php";
	public static final String service_PreglediGetURL = ServiceURL.webServiceUrl + "/VratiPreglede.php";
}
