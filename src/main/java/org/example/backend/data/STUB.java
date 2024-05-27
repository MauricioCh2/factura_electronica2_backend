package org.example.backend.data;

import org.example.backend.logic.ActividadEntity;
import org.example.backend.logic.ProveedorActividadEntity;
import org.example.backend.logic.UsuarioEntity;
import org.example.backend.tools;

import java.util.ArrayList;
import java.util.List;

public class STUB {
    private final List<UsuarioEntity> proveedoresAprobados;
    private final List<ActividadEntity> actividadsComerciales;

    private final List<ProveedorActividadEntity> provActividades;

    public STUB() {

        proveedoresAprobados = List.of(
                new UsuarioEntity("111", "pedrito", "FIS"),
                new UsuarioEntity("111111111", "pruebaFis", "FIS"),
                new UsuarioEntity("2222222222", "pruebaJur", "JUR"),
                new UsuarioEntity("33333333333", "pruebaExt", "EXT"),
                new UsuarioEntity("2", "Ashly", "FIS"),
                new UsuarioEntity("4", "Mauricio", "JUR"),
                new UsuarioEntity("5", "Jairo",  "FIS"),
                new UsuarioEntity("6", "Daniel","JUR"),
                new UsuarioEntity("7", "Andrey","FIS"),
                new UsuarioEntity("111", "PROV1","FIS"),
                new UsuarioEntity("2222", "PROV2","JUR")
        );
        actividadsComerciales = List.of(
                //productos
                new ActividadEntity(1,"Otros"),
                new ActividadEntity(62521, "Servicios de venta al por menor de frutas y vegetales, prestados a comisión o por contrato"),
                new ActividadEntity(47610, "Discos, cintas u otros medios físicos de audio musical"),
                new ActividadEntity(62553, "Servicios de venta al por menor de juegos y juguetes, prestados a comisión o por contrato (bienes que son propiedad de otros)"),
                new ActividadEntity(88167, "Servicios de elaboración de comidas y platos preparados"),
                new ActividadEntity(21111, "Carne de res, fresca o refrigerada"),
                new ActividadEntity(21121, "Carne de pollo, fresca o refrigerada"),
                //servicionew ActividadEntity("84391", "Servicios de juegos en línea (on-line), n.c.p."),
                new ActividadEntity(38961, "Pinturas, dibujos y pasteles; grabados, estampas y litografías originales; esculturas y estatuas originales, de cualquier material"),
                new ActividadEntity(88906, "Servicios de fabricación de juegos y juguetes"),
                new ActividadEntity(92912, "Servicios de educación deportiva y recreativa"),
                new ActividadEntity(92919, "Servicios de educación y capacitación, n.c.p.")
        );

        this.provActividades = List.of(//despues hacer que esto tenga logica
                new ProveedorActividadEntity("2222222222", 21121),
                new ProveedorActividadEntity("2222222222", 21111),
                new ProveedorActividadEntity("2222222222", 88167),

                new ProveedorActividadEntity("111", 88906),
                new ProveedorActividadEntity("111", 62553),

                new ProveedorActividadEntity("2", 92912),
                new ProveedorActividadEntity("2", 92919),


                new ProveedorActividadEntity("4", 62521),
                new ProveedorActividadEntity("4", 62553),
                new ProveedorActividadEntity("4", 47610),
                new ProveedorActividadEntity("4", 88167),
                new ProveedorActividadEntity("4", 21111),
                new ProveedorActividadEntity("4", 21121),
                new ProveedorActividadEntity("5", 84391),
                new ProveedorActividadEntity("5", 38961),
                new ProveedorActividadEntity("5", 88906),
                new ProveedorActividadEntity("5", 92912),
                new ProveedorActividadEntity("5", 92919),
                new ProveedorActividadEntity("6", 62521),
                new ProveedorActividadEntity("6", 62553),
                new ProveedorActividadEntity("6", 47610),
                new ProveedorActividadEntity("6", 88167),
                new ProveedorActividadEntity("6", 21111),
                new ProveedorActividadEntity("6", 21121),
                new ProveedorActividadEntity("7", 84391),
                new ProveedorActividadEntity("7", 38961),
                new ProveedorActividadEntity("7", 88906),
                new ProveedorActividadEntity("7", 92912),
                new ProveedorActividadEntity("7", 92919),
                new ProveedorActividadEntity("111", 84391),
                new ProveedorActividadEntity("111", 38961)
        );

    }
    //agregart un par de actividades comerciales a cada uno como opcion para el proveedor

    public Iterable<UsuarioEntity> getProveedoresAprobados() {
        return proveedoresAprobados;
    }
    public Boolean verifyNewProveedor(UsuarioEntity proveedor) {//aqui solo validar el id del proveedor
        return proveedoresAprobados.stream().anyMatch(p ->
                p.getIdUsuario().equals(proveedor.getIdUsuario())
        );
    }

    public Iterable<ProveedorActividadEntity> getActividadesProv(String id){
        return provActividades.stream().filter(p -> p.getIdUsuario().equals(id))::iterator;
    }
    public List<ActividadEntity> getActividadesByProveedor(String proveedorId) {
        List<ActividadEntity> actividades = new ArrayList<>();

        for (ProveedorActividadEntity provAct : provActividades) {
            if (provAct.getIdUsuario().equals(proveedorId)) {
                int actividadId = provAct.getIdActividad();
                ActividadEntity actividad = actividadsComerciales.stream()
                        .filter(act -> act.getIdActividad() == actividadId)
                        .findFirst()
                        .orElse(null);
                if (actividad != null) {
                    actividades.add(actividad);
                }
            }
        }

        return actividades;
    }
}
