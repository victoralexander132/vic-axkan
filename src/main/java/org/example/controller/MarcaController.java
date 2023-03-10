package org.example.controller;

import org.example.model.Marca;
import org.example.model.Modelo;
import org.example.model.Tipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class MarcaController {

    public void printQuery() {
        // SessionFactory
        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Marca.class)
                .addAnnotatedClass(Tipo.class)
                .addAnnotatedClass(Modelo.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            // Query that joins the tables
            Query query = session.createQuery("select ma.marca, ma.descripcion, t.tipoAuto, t.descripcion, t.capacidad, m.modelo, m.descripcion, m.fechaAlta from Tipo t" +
                    " join Modelo m on t.id = m.tipo.id" +
                    " join Marca ma on m.marca.id = ma.id");
            List<Object[]> list = query.list();

            // Write results to file
            File file = new File("Completo.txt");
            FileWriter writer = new FileWriter(file);
            for (Object[] arr : list) {
                String line = String.format("%s|%s|%s|%s|%s|%s|%s|%s%n",
                        arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                writer.write(line);
            }
            writer.close();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void printQuery(int marcaId) {
        // SessionFactory
        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Marca.class)
                .addAnnotatedClass(Tipo.class)
                .addAnnotatedClass(Modelo.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            // Query that joins the tables
            Query query = session.createQuery("select ma.marca, ma.descripcion, t.tipoAuto, t.descripcion, t.capacidad, m.modelo, m.descripcion, m.fechaAlta from Tipo t" +
                    " join Modelo m on t.id = m.tipo.id" +
                    " join Marca ma on m.marca.id = ma.id" +
                    " where ma.id = :marcaId").setParameter("marcaId", marcaId);
            List<Object[]> list = query.list();
            // Write results to file
            File file = new File("PorMarca.txt");
            FileWriter writer = new FileWriter(file);
            for (Object[] arr : list) {
                String line = String.format("%s|%s|%s|%s|%s|%s|%s|%s%n",
                        arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                writer.write(line);
            }
            writer.close();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
