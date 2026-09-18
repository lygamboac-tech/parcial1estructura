
package parcial1;

import java.util.Scanner;

public class Funciones {
    private Node <Funciones> head;
    private int codigo;
    private String nombre;
    private String hora;
    private String [] puestos;

    public Funciones(int codigo, String nombre, String hora, String[] puestos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.hora = hora;
        this.puestos = puestos;
    }
    
    public Funciones() {
        head = null;
    }
    
    public Node <Funciones> getHead() {
        return head;
    }

    public void setHead(Node <Funciones> head) {
        this.head = head;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String[] getPuestos() {
        return puestos;
    }

    public void setPuestos(String[] puestos) {
        this.puestos = puestos;
    }
    
    public void Log(int codigo, String nombre, String hora) {

        Node<Funciones> actual = head;
        while (actual != null) {
            if (actual.getData().getCodigo() == codigo) {
                System.out.println("ERROR, función ya registrada");
                return;
            }
            actual = actual.getNext();
        }
        String[] puestos = new String[20];

        for (int i = 0; i < 20; i++) {
            puestos[i] = "d";
        }

        Funciones funcion = new Funciones(codigo, nombre, hora, puestos);
        Node<Funciones> nuevo = new Node<>(funcion, null);

        if (head == null) {
            head = nuevo;
        } else {
            actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
        }
        System.out.println("Funcion registrada");
        System.out.println();

    }
    
    public void Buy (int codigo){
        Scanner sc = new Scanner(System.in);
        Node<Funciones> actual = head;

        while (actual != null) {
            if (actual.getData().getCodigo() == codigo) {

                System.out.println("Nombre = " + actual.getData().getNombre());
                System.out.println("Hora = " + actual.getData().getHora());
                System.out.println("Puestos");
                int c = 0;
                for (int i = 0; i < 5; i++){
                    for (int x = 0; x < 4; x++){
                        System.out.print((c+1) + actual.getData().getPuestos()[x]+ "  ");
                        c++;
                    }
                    System.out.println();
                }
                System.out.println("PUESTO A COMPRAR");
                int puesto = sc.nextInt();
                while (true) {
                    if (puesto < 1 || puesto > 20) {
                        System.out.println("El rango es entre 1 y 20.");
                    } 
                    else if (actual.getData().getPuestos()[puesto - 1].equals("o")) {
                        System.out.println("Puesto ocupado. Digite otro puesto:");
                    } 
                    else {
                        actual.getData().getPuestos()[puesto - 1] = "o";
                        System.out.println("Vendido correctamente.");
                        return;
                    }
                    puesto = sc.nextInt();
                }
            }
            actual = actual.getNext();
        }
        System.out.println("La funcion no existe.");
        System.out.println();

    }
        
    
    public void Start (){
        Scanner sc = new Scanner (System.in);
        Node<Funciones> actual = head;
        while (actual != null){
            System.out.println("Funcion " + " = " +  "Nombre " + actual.getData().getNombre());
            System.out.println("Hora: " + actual.getData().getHora());
            System.out.println("Codigo: " + actual.getData().getCodigo());
            System.out.println("Puestos : ");
            int vendidos = 0;
            int disponibles = 0;
                for (int i = 0; i < actual.getData().getPuestos().length; i++){
                    if (actual.getData().getPuestos()[i].equals("d")){
                        disponibles++;
                    } else {
                        vendidos++;
                    }
                }
                System.out.println("disponibles = " + disponibles);  
                System.out.println("vendidos = " + vendidos);
                System.out.println("Oprima una tecla");
                String teclado = sc.nextLine();
                actual = actual.getNext();        
                System.out.println();

        }
        System.out.println("Funciones terminadas");
        System.out.println();
    }
}
    
    
    
