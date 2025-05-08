package com.example.emailevents.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/companies")
public class SparkyController {

    private final EmpresaService empresaService;
    @PostMapping
    public ResponseEntity<Empresa> CreateEmpresa(@RequestBody Empresa empresa){
        Empresa CreateEmpresa = empresaService.CreateEmpresa
        ResponseEntity.ok(CreateEmpresa);


    }
    @GetMapping
    public List<Empresa> listadeEmp(){
        return empresaService.findAll();
    }
    @GetMapping("/{id}")
    public Empresadto ObtenerEmpresa(@PathVariable Long id){
        return empresaService.findById();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaUpdateRequest request) {
        empresaService.actualizarEmpresa(id, request);
        return ResponseEntity.ok(Map.of("mensaje", "Empresa actualizada correctamente"));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> cambiarEstadoEmpresa(@PathVariable Long id, @RequestBody EstadoRequest request) {
        empresaService.cambiarEstado(id, request.isActiva());
        String msg = request.isActiva() ? "Empresa activada" : "Empresa desactivada";
        return ResponseEntity.ok(Map.of("mensaje", msg));
    }

    @GetMapping("/{id}/consumption")
    public ConsumoEmpresaDTO obtenerConsumoEmpresa(@PathVariable Long id) {
        return empresaService.obtenerConsumo(id);
    }
}
