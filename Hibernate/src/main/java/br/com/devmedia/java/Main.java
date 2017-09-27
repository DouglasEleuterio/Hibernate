package br.com.devmedia.java;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    /* Primeiramente precisamos do Entity Manage Factory*/
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa"); // hibernatejpa Informado no POM


        /* Remove Lembrete
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            Lembrete lembrete = em.find(Lembrete.class, 3L);

            em.getTransaction().begin();
            em.remove(lembrete);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("DELETE: " +e.getMessage());
        } finally {
            em.close();
       }
       */

        /* Atualização do Registro
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            Lembrete lembrete = em.find(Lembrete.class, 2L);

            lembrete.setTitulo("Comprar café");
            lembrete.setDescricao("Hoje, 8h22");

            em.getTransaction().begin();
            em.merge(lembrete);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("UPDATE: " +e.getMessage());
        } finally {
            em.close();
        }
        */

        /*
         * Busca Customizada no Banco, lembrando que a busca não e feita diretamente no banco,
         * mas é criada classe com os valores contidos no banco, deixando o programa mais ágil.
         * para bucar dado de uma tabela dirente do registro não altera em nada meu código, por que estou trabalhando com bjetos

        List<Lembrete> lembretes = null;

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            lembretes = em.createQuery("from Lembrete l where l.titulo LIKE '%comprar%' ").getResultList(); // Criando uma string personalizada
        } catch (Exception e){
            System.out.println("LISTA ALL: " +e.getMessage());
        } finally {
            em.close();
        }

        if (lembretes != null) {
            lembretes.forEach(System.out :: println);
        }
        */


        /*
        //Buscando o registro pela chave primaria
        EntityManager em = entityManagerFactory.createEntityManager();

        Lembrete lembrete = null;

        try {
            lembrete = em.find(Lembrete.class, 1L); //1 Id da busca

            System.out.println(lembrete);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        */

        /*
         * Recuperando todos dados do banco
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa"); // hibernatejpa Informado no POM

        List<Lembrete> lembretes = null;

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            lembretes = em.createQuery("from Lembrete").getResultList(); // O Lembrete não representa a tabela Lembrete do banco, mas refere-se a classe Lembrete
        } catch (Exception e){
            System.out.println("LISTA ALL: " +e.getMessage());
        } finally {
            em.close();
        }

        if (lembretes != null) {
            lembretes.forEach(System.out :: println);
        }
        */

        /*
         * Inserindo os dados na tabela
        Lembrete lembrete = new Lembrete();
        lembrete.setTitulo("Comprar Leite");
        lembrete.setDescricao("Hoje, 10h30");

        EntityManager em =  entityManagerFactory.createEntityManager();

        try {
          em.getTransaction().begin(); //Informo o EntityManager que será realizada uma operação no banco
          em.persist(lembrete); // Informo qual classe será usada
          em.getTransaction().commit(); //Faço o Commit
        } catch (Exception e) {
            em.getTransaction().rollback(); // Caso ocorra alguma exception, faço o RoolBack.

            System.out.println("INSERT: " + e.getMessage()); //Exibo a mensagem de erro
        }

        finally {
            em.close(); // No fim, se for persistido ou não, finalizo o EntityManager
        }
        */
    }
}
