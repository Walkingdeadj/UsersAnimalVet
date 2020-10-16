package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.PetList;
import model.Owner;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PetListHelper lih = new PetListHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerPNum = request.getParameter("ownerPNum");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
			Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedPets = request.getParameterValues("allPetsToAdd");
		List<PetList> selectedPetsInList = new ArrayList<PetList>();
			//make sure something was selected ¨C otherwise we get a null pointer exception
		if (selectedPets != null && selectedPets.length > 0)
		{
			for(int i = 0; i<selectedPets.length; i++) {
			System.out.println(selectedPets[i]);
			PetList c = lih.searchForPetById(Integer.parseInt(selectedPets[i]));
			selectedPetsInList.add(c);
			}
		}
		Owner owner = new Owner(ownerPNum);
		ListDetails sld = new ListDetails(listName, ld, owner);
		sld.setListOfPets(selectedPetsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
