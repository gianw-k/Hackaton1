package com.example.emailevents.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/company/users")
@RequiredArgsConstructor
public class CompanyUserController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioRequest request, @AuthenticationPrincipal UsuarioAuth auth) {
        usuarioService.crearUsuario(request, auth.getEmpresaId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", "Usuario creado exitosamente"));
    }

    
    @GetMapping
    public List<UsuarioResumenDTO> listarUsuarios(@AuthenticationPrincipal UsuarioAuth auth) {
        return usuarioService.listarUsuariosPorEmpresa(auth.getEmpresaId());
    }


    @GetMapping("/{id}")
    public UsuarioDetalleDTO obtenerUsuario(@PathVariable Long id, @AuthenticationPrincipal UsuarioAuth auth) {
        return usuarioService.obtenerUsuarioDetalle(id, auth.getEmpresaId());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioUpdateRequest request, @AuthenticationPrincipal UsuarioAuth auth) {
        usuarioService.actualizarUsuario(id, request, auth.getEmpresaId());
        return ResponseEntity.ok(Map.of("mensaje", "Usuario actualizado correctamente"));
    }


    @PostMapping("/{id}/limits")
    public ResponseEntity<?> asignarLimite(@PathVariable Long id, @RequestBody LimiteUsuarioRequest request, @AuthenticationPrincipal UsuarioAuth auth) {
        usuarioService.asignarLimite(id, request, auth.getEmpresaId());
        return ResponseEntity.ok(Map.of("mensaje", "Límite asignado exitosamente"));
    }

    // 6. Obtener consumo del usuario
    @GetMapping("/{id}/consumption")
    public ConsumoUsuarioDTO obtenerConsumo(@PathVariable Long id, @AuthenticationPrincipal UsuarioAuth auth) {
        return usuarioService.obtenerConsumo(id, auth.getEmpresaId());
    }
}
