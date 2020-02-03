package com.atelier.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atelier.services.Carburant;
import com.atelier.services.Station;
import com.atelier.services.StationServiceProxy;
import com.sun.xml.internal.ws.client.Stub;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StationServiceProxy  stub;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		stub=new StationServiceProxy();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Sign in 
		if(request.getParameter("operation").equals("login")) {
			String user=request.getParameter("username");
			String pass=request.getParameter("pass");
			if(!user.isEmpty() && !pass.isEmpty()) {
				if(user.equals("admin") && pass.equals("admin")) {
					//Send model connexion
					request.setAttribute("modelcnx", true);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					request.setAttribute("modeleError", "Password or Username false ");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("modeleError", "Password or Username false");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else 
		/*****************************Signout****************************/ 
		if(request.getParameter("operation").equals("signout")) {
			//Disconnect Admin
			request.setAttribute("modelcnx", false);
			request.getRequestDispatcher("index.jsp").forward(request, response);	
			/*****************************Send Station will Edit****************************/ 
		}else if(request.getParameter("operation").equals("editeStation")){	
			try {
			  //Save login Admin
				request.setAttribute("modelcnx", true);
				//Send Modal for open form 
				request.setAttribute("editstation",true);
				//Send Modal for Station want edit 
				request.setAttribute("Stationedite",stub.getStation(Integer.valueOf(request.getParameter("stId"))));
			    
			} catch (Exception e) {
				System.out.println("editstation : "+e.getMessage());
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			/*****************************Add Station ****************************/ 
		}else if(request.getParameter("operation").equals("addStation")) {
			try {
			  //Save login Admin
				request.setAttribute("modelcnx", true);
				String stName=request.getParameter("stName");
				String stVille=request.getParameter("stVille");
				String stAddress=request.getParameter("stAddress");
				//Station st=new Station(stid,stName,stVille,stAddress);
				stub.createStation(stName, stVille, stAddress);
				//Send Modal for open form 
				request.setAttribute("editstation",false);
			} catch (Exception e) {
				System.out.println("stationedit : "+e.getMessage());
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			/*****************************Edit Station ****************************/ 
		}else if(request.getParameter("operation").equals("StationEdit")) {
			try {
			  //Save login Admin
				request.setAttribute("modelcnx", true);
				int stid=Integer.valueOf(request.getParameter("stIdEdit"));
				String stName=request.getParameter("stNomEdit");
				String stVille=request.getParameter("stVilleEdit");
				String stAddress=request.getParameter("stAddressEdit");
				//Station st=new Station(stid,stName,stVille,stAddress);
				stub.upateStation(stid, stName, stVille, stAddress);
				//Send Modal for Close form 
				request.setAttribute("editstation",false);
			} catch (Exception e) {
				System.out.println("stationedit : "+e.getMessage());
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);	
			/*****************************Delete Station ****************************/ 
		}else if(request.getParameter("operation").equals("deleteStation")) {
			try {	
			  //Save login Admin
				request.setAttribute("modelcnx", true);
				stub.deleteStation(Integer.valueOf(request.getParameter("stId")));
			} catch (Exception e) {
				System.out.println("deleteStation : "+e.getMessage());
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);	
			/*****************************Delete Carburant ****************************/ 
		}else if(request.getParameter("operation").equals("deleteCarburant")) {
			try {	
				  //Save login Admin
					request.setAttribute("modelcnx", true);
					stub.deleteCarburant(Integer.valueOf(request.getParameter("carbId")));
				} catch (Exception e) {
					System.out.println("deleteCarburant : "+e.getMessage());
				}
				request.getRequestDispatcher("index.jsp").forward(request, response);	
				/***************************** Send Carburant you want edit ****************************/
			}else if(request.getParameter("operation").equals("editeCarburant")){	
				try {
					  //Save login Admin
						request.setAttribute("modelcnx", true);
						//Send Modal for open form 
						request.setAttribute("editCarburant",true);
						//Send Modal for Station want edit 
						request.setAttribute("Carburantedit",stub.getCarburant(Integer.valueOf(request.getParameter("carbId"))));
					    
					} catch (Exception e) {
						System.out.println("editeCarburant : "+e.getMessage());
					}
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
					/*****************************Edit Carburant ****************************/ 
				}else if(request.getParameter("operation").equals("CarburantEdit")) {
					try {
						  //Save login Admin
							request.setAttribute("modelcnx", true);
							int carbid=Integer.valueOf(request.getParameter("carbIdEdit"));
							String carbName=request.getParameter("carbNomEdit");
							String carbDesc=request.getParameter("carbDescEdit");
							stub.upateCarburant(carbid, carbName, carbDesc);
							//Send Modal for Close form 
							request.setAttribute("editCarburant",false);
						} catch (Exception e) {
							System.out.println("stationedit : "+e.getMessage());
						}
						request.getRequestDispatcher("index.jsp").forward(request, response);	
						
						/*****************************Add Carburant ****************************/ 
						
					}else if(request.getParameter("operation").equals("AddCarburant")) {
						try {
							  //Save login Admin
								request.setAttribute("modelcnx", true);
								String carbName=request.getParameter("carbNom");
								String carbDesc=request.getParameter("carbDesc");
								stub.createCarburant(carbName, carbDesc);
							} catch (Exception e) {
								System.out.println("Carburantadd : "+e.getMessage());
							}
							request.getRequestDispatcher("index.jsp").forward(request, response);	
							
						}
				
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
