package eu.cisong.ftp;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.log4j.Logger;

public class FTPSession {
	private String ftpHost;
	private int ftpPort;
	private String ftpUsername;
	private String ftpPassword;
	private String proxyHost;
	private int proxyPort;
	private String proxyUsername;
	private String proxyPassword;
	
	private FTPClient ftpClient;
	
	private Logger logger = Logger.getLogger(FTPSession.class);
	
	@SuppressWarnings("unused")
	public void onInit() throws SocketException, IOException{
		if(proxyPort < 1){
			ftpClient = new FTPClient();
		} else {
			ftpClient = new FTPHTTPClient(proxyHost, proxyPort, proxyUsername, proxyPassword);
		}
		
		ftpClient.connect(ftpHost);
		ftpClient.login(ftpUsername, ftpPassword);
		logger.debug(ftpClient.getReplyString());
	}
	
	public FTPFile[] listFiles(String dirPath, String filePattern) throws IOException{
		ftpClient.changeWorkingDirectory(dirPath);
		return ftpClient.listFiles();
	}
	
	public void onDestroy(){}
	
	public String getFtpHost() {
		return ftpHost;
	}
	public void setFtpHost(String ftpHost) {
		this.ftpHost = ftpHost;
	}
	public int getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpUsername() {
		return ftpUsername;
	}

	public void setFtpUsername(String ftpUsername) {
		this.ftpUsername = ftpUsername;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUsername() {
		return proxyUsername;
	}

	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}
}
