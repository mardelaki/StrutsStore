package my.pack;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class StoreAction extends ActionSupport implements ServletResponseAware,
		ServletRequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map session;
	private String Qcafe;
	private String Qsugar;
	private String Qwater;
	private double coffeeTotal;
	private double sugarTotal;
	private double waterTotal;
	private double total;

	public String populate() {
		// Load from cookie
		Qcafe = "0.0";
		Qsugar = "0.0";
		Qwater = "0.0";
		if ((servletRequest.getCookies() != null)
				&& (servletRequest.getCookies().length != 0)) {
			for (Cookie c : servletRequest.getCookies()) {
				if (c.getName().equals("ct"))
					Qcafe = c.getValue();
				if (c.getName().equals("st"))
					Qsugar = c.getValue();
				if (c.getName().equals("wt"))
					Qwater = c.getValue();
			}
		}

		coffeeTotal = Double.parseDouble(Qcafe) * 18.50;
		sugarTotal = Double.parseDouble(Qsugar) * 6.95;
		waterTotal = Double.parseDouble(Qwater) * 1.29;
		total = Double.parseDouble(Qwater) * 1.29 + Double.parseDouble(Qsugar)
				* 6.95 + Double.parseDouble(Qcafe) * 18.50;

		return "populate";
	}

	public String execute() {

		if(this.Qcafe.isEmpty() || this.Qsugar.equals("")){
			this.Qcafe="0.0";
			}
		if(this.Qsugar.isEmpty() || this.Qsugar.equals("")){this.Qsugar="0.0";}
		if(this.Qwater.isEmpty() || this.Qwater.equals("")){this.Qwater="0.0";}
		this.coffeeTotal = Double.parseDouble(this.Qcafe) * 18.50;
		this.sugarTotal = Double.parseDouble(this.Qsugar) * 6.95;
		this.waterTotal = Double.parseDouble(this.Qwater) * 1.29;
		this.total = Double.parseDouble(this.Qwater) * 1.29
				+ Double.parseDouble(this.Qsugar) * 6.95
				+ Double.parseDouble(this.Qcafe) * 18.50;
		Cookie c1 = new Cookie("ct", this.Qcafe);
		c1.setMaxAge(60 * 60 * 24 * 365); // Make the cookie last a year
		servletResponse.addCookie(c1);
		Cookie c2 = new Cookie("st", this.Qsugar);
		c2.setMaxAge(60 * 60 * 24 * 365); // Make the cookie last a year
		servletResponse.addCookie(c2);
		Cookie c3 = new Cookie("wt", this.Qwater);
		c3.setMaxAge(60 * 60 * 24 * 365); // Make the cookie last a year
		servletResponse.addCookie(c3);
		return "success";

	}

	// For access to the raw servlet request / response, eg for cookies
	protected HttpServletResponse servletResponse;

	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	protected HttpServletRequest servletRequest;

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public String getQcafe() {
		return Qcafe;
	}

	public void setQcafe(String qcafe) {
		Qcafe = qcafe;
	}

	public String getQsugar() {
		return Qsugar;
	}

	public void setQsugar(String qsugar) {
		Qsugar = qsugar;
	}

	public String getQwater() {
		return Qwater;
	}

	public void setQwater(String qwater) {
		Qwater = qwater;
	}

	public double getCoffeeTotal() {
		return coffeeTotal;
	}

	public void setCoffeeTotal(double coffeeTotal) {
		this.coffeeTotal = coffeeTotal;
	}

	public double getSugarTotal() {
		return sugarTotal;
	}

	public void setSugarTotal(double sugarTotal) {
		this.sugarTotal = sugarTotal;
	}

	public double getWaterTotal() {
		return waterTotal;
	}

	public void setWaterTotal(double waterTotal) {
		this.waterTotal = waterTotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setSession(Map session) {
		session = this.getSession();
	}

	public Map getSession() {
		return session;
	}

}
