/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author STALING
 */
@WebServlet(name = "Imagenes", urlPatterns = {"/imagen"})
public class Imagenes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        try {
            File foto = null;
            int ancho = 0, alto = 0, escalaAncho = 0, escalaAlto = 0;
            String Ruta = request.getServletContext().getRealPath("resources/images");
            double porcentaje = Double.parseDouble("0." + request.getParameter("porcentaje"));
            int anchoss = Integer.parseInt(request.getParameter("ancho"));
            int altoss = Integer.parseInt(request.getParameter("alto"));
            foto = new File(Ruta.concat("/").concat(request.getParameter("foto")));
            if (foto.exists()) {
                try {
                    BufferedImage bf = ImageIO.read(foto);
                    ancho = bf.getWidth();
                    alto = bf.getHeight();
                    if(Integer.parseInt(request.getParameter("porcentaje"))>15){
                    escalaAncho = (int) (porcentaje * ancho);
                    escalaAlto = (int) (porcentaje * alto);
                    }else{
                     escalaAncho = anchoss;
                    escalaAlto = altoss;
                    }
                   
                    BufferedImage bufim = new BufferedImage(escalaAncho, escalaAlto, bf.getType());
                    Graphics2D g = bufim.createGraphics();
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.drawImage(bf, 0, 0, escalaAncho, escalaAlto, 0, 0, ancho, alto, null);
                    g.dispose();

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bufim, "jpg", baos);
                    response.getOutputStream().write(baos.toByteArray());
                } catch (Exception e) {
                }
            } else {
                response.getOutputStream().print("Ruta no existe");

            }

        } catch (Exception e) {
             response.getOutputStream().print("Error "+e);


        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
