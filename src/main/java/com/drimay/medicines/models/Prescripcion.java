/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drimay.medicines.models;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author jaime
 */

@Entity
@Table(name = "prescripcion")
@EntityListeners(AuditingEntityListener.class)
public class Prescripcion {
    
    @Id
    private String id;
    
    @Column(name = "biosimilar", nullable = true, length = 1)
    private String biosimilar;
    
    @Column(name = "cod_nacionales_inactivos", nullable = true, length = 4000)
    private String codNacionalesInactivos;
    
    @Column(name = "cod_sitreg_presen_id", nullable = true, length = 255)
    private String codSitregPresenId;
    
    @Column(name = "contenido", nullable = true, length = 255)
    private String contenido;
    
    @Column(name = "des_dosific", nullable = true, length = 4000)
    private String desDosific;
    
    @Column(name = "des_nomco", nullable = true, length = 4000)
    private String desNomco;
    
    @Column(name = "des_prese", nullable = true, length = 4000)
    private String desPrese;
    
    @Column(name = "fec_comer", nullable = true)
    private LocalDate fecComer;
    
    @Column(name = "fec_sitreg_presen", nullable = true)
    private LocalDate fecSitregPresen;
    
    @Column(name = "fecha_autorizacion", nullable = true)
    private LocalDate fechaAutorizacion;
    
    @Column(name = "fecha_situacion_registro", nullable = true)
    private LocalDate fechaSituacionRegistro;
    
    @Column(name = "importacion_paralela", nullable = true, length = 1)
    private String importacionParalela;
    
    @Column(name = "lista_estupefaciente", nullable = true, length = 255)
    private String listaEstupefaciente;
    
    @Column(name = "lista_psicotropo", nullable = true, length = 255)
    private String listaPsicotropo;
    
    @Column(name = "nro_conte", nullable = true, length = 1000)
    private String nroConte;
    
    @Column(name = "nro_definitivo", nullable = true, length = 255)
    private String nroDefinitivo;
    
    @Column(name = "sw_afecta_conduccion", nullable = true, length = 1)
    private String swAfectaConduccion;
    
    @Column(name = "sw_base_a_plantas", nullable = true, length = 1)
    private String swBaseAPlantas;
    
    @Column(name = "sw_comercializado", nullable = true, length = 1)
    private String swComercializado;
    
    @Column(name = "sw_diagnostico_hospitalario", nullable = true, length = 1)
    private String swDiagnosticoHospitalario;
    
    @Column(name = "sw_envase_clinico", nullable = true, length = 1)
    private String swEnvaseClinico;
    
    @Column(name = "sw_especial_control_medico", nullable = true, length = 1)
    private String swEspecialControlMedico;
    
    @Column(name = "sw_estupefaciente", nullable = true, length = 1)
    private String swEstupefaciente;
    
    @Column(name = "sw_generico", nullable = true, length = 1)
    private String swGenerico;
    
    @Column(name = "sw_huerfano", nullable = true, length = 1)
    private String swHuerfano;
    
    @Column(name = "sw_psicotropo", nullable = true, length = 1)
    private String swPsicotropo;
    
    @Column(name = "sw_receta", nullable = true, length = 1)
    private String swReceta;
    
    @Column(name = "sw_sustituible", nullable = true, length = 1)
    private String swSustituible;
    
    @Column(name = "sw_tiene_excipientes_decl_obligatoria", nullable = true, length = 1)
    private String swTieneExcipientesDeclObligatoria;
    
    @Column(name = "sw_tld", nullable = true, length = 1)
    private String swTld;
    
    @Column(name = "sw_triangulo_negro", nullable = true, length = 1)
    private String swTrianguloNegro;
    
    @Column(name = "sw_uso_hospitalario", nullable = true, length = 1)
    private String swUsoHospitalario;
    
    @Column(name = "url_fic_tec", nullable = true, length = 4000)
    private String urlFicTec;
    
    @Column(name = "url_prosp", nullable = true, length = 4000)
    private String urlProsp;
    
    @Column(name = "cod_dcp_id", nullable = true, length = 255)
    private String codDcpId;
    
    @Column(name = "cod_dcsa_id", nullable = true, length = 255)
    private String codDcsaId;
    
    @Column(name = "cod_envase_id", nullable = true, length = 255)
    private String codEnvaseId;
    
    @Column(name = "cod_sitreg_id", nullable = true, length = 255)
    private String codSitregId;
    
    @Column(name = "codigo_dcpf_id", nullable = true, length = 255)
    private String codigoDcpfId;
    
    @Column(name = "laboratorio_comercializador_id", nullable = true, length = 255)
    private String laboratorioComercializadorId;
    
    @Column(name = "laboratorio_titular_id", nullable = true, length = 255)
    private String laboratorioTitularId;
    
    @Column(name = "unid_contenido_id", nullable = true, length = 255)
    private String unidContenidoId;

    public Prescripcion() {
    }

    public Prescripcion(String id, String biosimilar, String codNacionalesInactivos, String codSitregPresenId, String contenido, String desDosific, String desNomco, String desPrese, LocalDate fecComer, LocalDate fecSitregPresen, LocalDate fechaAutorizacion, LocalDate fechaSituacionRegistro, String importacionParalela, String listaEstupefaciente, String listaPsicotropo, String nroConte, String nroDefinitivo, String swAfectaConduccion, String swBaseAPlantas, String swComercializado, String swDiagnosticoHospitalario, String swEnvaseClinico, String swEspecialControlMedico, String swEstupefaciente, String swGenerico, String swHuerfano, String swPsicotropo, String swReceta, String swSustituible, String swTieneExcipientesDeclObligatoria, String swTld, String swTrianguloNegro, String swUsoHospitalario, String urlFicTec, String urlProsp, String codDcpId, String codDcsaId, String codEnvaseId, String codSitregId, String codigoDcpfId, String laboratorioComercializadorId, String laboratorioTitularId, String unidContenidoId) {
        this.id = id;
        this.biosimilar = biosimilar;
        this.codNacionalesInactivos = codNacionalesInactivos;
        this.codSitregPresenId = codSitregPresenId;
        this.contenido = contenido;
        this.desDosific = desDosific;
        this.desNomco = desNomco;
        this.desPrese = desPrese;
        this.fecComer = fecComer;
        this.fecSitregPresen = fecSitregPresen;
        this.fechaAutorizacion = fechaAutorizacion;
        this.fechaSituacionRegistro = fechaSituacionRegistro;
        this.importacionParalela = importacionParalela;
        this.listaEstupefaciente = listaEstupefaciente;
        this.listaPsicotropo = listaPsicotropo;
        this.nroConte = nroConte;
        this.nroDefinitivo = nroDefinitivo;
        this.swAfectaConduccion = swAfectaConduccion;
        this.swBaseAPlantas = swBaseAPlantas;
        this.swComercializado = swComercializado;
        this.swDiagnosticoHospitalario = swDiagnosticoHospitalario;
        this.swEnvaseClinico = swEnvaseClinico;
        this.swEspecialControlMedico = swEspecialControlMedico;
        this.swEstupefaciente = swEstupefaciente;
        this.swGenerico = swGenerico;
        this.swHuerfano = swHuerfano;
        this.swPsicotropo = swPsicotropo;
        this.swReceta = swReceta;
        this.swSustituible = swSustituible;
        this.swTieneExcipientesDeclObligatoria = swTieneExcipientesDeclObligatoria;
        this.swTld = swTld;
        this.swTrianguloNegro = swTrianguloNegro;
        this.swUsoHospitalario = swUsoHospitalario;
        this.urlFicTec = urlFicTec;
        this.urlProsp = urlProsp;
        this.codDcpId = codDcpId;
        this.codDcsaId = codDcsaId;
        this.codEnvaseId = codEnvaseId;
        this.codSitregId = codSitregId;
        this.codigoDcpfId = codigoDcpfId;
        this.laboratorioComercializadorId = laboratorioComercializadorId;
        this.laboratorioTitularId = laboratorioTitularId;
        this.unidContenidoId = unidContenidoId;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBiosimilar() {
        return biosimilar;
    }

    public void setBiosimilar(String biosimilar) {
        this.biosimilar = biosimilar;
    }

    public String getCodNacionalesInactivos() {
        return codNacionalesInactivos;
    }

    public void setCodNacionalesInactivos(String codNacionalesInactivos) {
        this.codNacionalesInactivos = codNacionalesInactivos;
    }

    public String getCodSitregPresenId() {
        return codSitregPresenId;
    }

    public void setCodSitregPresenId(String codSitregPresenId) {
        this.codSitregPresenId = codSitregPresenId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDesDosific() {
        return desDosific;
    }

    public void setDesDosific(String desDosific) {
        this.desDosific = desDosific;
    }

    public String getDesNomco() {
        return desNomco;
    }

    public void setDesNomco(String desNomco) {
        this.desNomco = desNomco;
    }

    public String getDesPrese() {
        return desPrese;
    }

    public void setDesPrese(String desPrese) {
        this.desPrese = desPrese;
    }

    public LocalDate getFecComer() {
        return fecComer;
    }

    public void setFecComer(LocalDate fecComer) {
        this.fecComer = fecComer;
    }

    public LocalDate getFecSitregPresen() {
        return fecSitregPresen;
    }

    public void setFecSitregPresen(LocalDate fecSitregPresen) {
        this.fecSitregPresen = fecSitregPresen;
    }

    public LocalDate getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(LocalDate fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public LocalDate getFechaSituacionRegistro() {
        return fechaSituacionRegistro;
    }

    public void setFechaSituacionRegistro(LocalDate fechaSituacionRegistro) {
        this.fechaSituacionRegistro = fechaSituacionRegistro;
    }

    public String getImportacionParalela() {
        return importacionParalela;
    }

    public void setImportacionParalela(String importacionParalela) {
        this.importacionParalela = importacionParalela;
    }

    public String getListaEstupefaciente() {
        return listaEstupefaciente;
    }

    public void setListaEstupefaciente(String listaEstupefaciente) {
        this.listaEstupefaciente = listaEstupefaciente;
    }

    public String getListaPsicotropo() {
        return listaPsicotropo;
    }

    public void setListaPsicotropo(String listaPsicotropo) {
        this.listaPsicotropo = listaPsicotropo;
    }

    public String getNroConte() {
        return nroConte;
    }

    public void setNroConte(String nroConte) {
        this.nroConte = nroConte;
    }

    public String getNroDefinitivo() {
        return nroDefinitivo;
    }

    public void setNroDefinitivo(String nroDefinitivo) {
        this.nroDefinitivo = nroDefinitivo;
    }

    public String getSwAfectaConduccion() {
        return swAfectaConduccion;
    }

    public void setSwAfectaConduccion(String swAfectaConduccion) {
        this.swAfectaConduccion = swAfectaConduccion;
    }

    public String getSwBaseAPlantas() {
        return swBaseAPlantas;
    }

    public void setSwBaseAPlantas(String swBaseAPlantas) {
        this.swBaseAPlantas = swBaseAPlantas;
    }

    public String getSwComercializado() {
        return swComercializado;
    }

    public void setSwComercializado(String swComercializado) {
        this.swComercializado = swComercializado;
    }

    public String getSwDiagnosticoHospitalario() {
        return swDiagnosticoHospitalario;
    }

    public void setSwDiagnosticoHospitalario(String swDiagnosticoHospitalario) {
        this.swDiagnosticoHospitalario = swDiagnosticoHospitalario;
    }

    public String getSwEnvaseClinico() {
        return swEnvaseClinico;
    }

    public void setSwEnvaseClinico(String swEnvaseClinico) {
        this.swEnvaseClinico = swEnvaseClinico;
    }

    public String getSwEspecialControlMedico() {
        return swEspecialControlMedico;
    }

    public void setSwEspecialControlMedico(String swEspecialControlMedico) {
        this.swEspecialControlMedico = swEspecialControlMedico;
    }

    public String getSwEstupefaciente() {
        return swEstupefaciente;
    }

    public void setSwEstupefaciente(String swEstupefaciente) {
        this.swEstupefaciente = swEstupefaciente;
    }

    public String getSwGenerico() {
        return swGenerico;
    }

    public void setSwGenerico(String swGenerico) {
        this.swGenerico = swGenerico;
    }

    public String getSwHuerfano() {
        return swHuerfano;
    }

    public void setSwHuerfano(String swHuerfano) {
        this.swHuerfano = swHuerfano;
    }

    public String getSwPsicotropo() {
        return swPsicotropo;
    }

    public void setSwPsicotropo(String swPsicotropo) {
        this.swPsicotropo = swPsicotropo;
    }

    public String getSwReceta() {
        return swReceta;
    }

    public void setSwReceta(String swReceta) {
        this.swReceta = swReceta;
    }

    public String getSwSustituible() {
        return swSustituible;
    }

    public void setSwSustituible(String swSustituible) {
        this.swSustituible = swSustituible;
    }

    public String getSwTieneExcipientesDeclObligatoria() {
        return swTieneExcipientesDeclObligatoria;
    }

    public void setSwTieneExcipientesDeclObligatoria(String swTieneExcipientesDeclObligatoria) {
        this.swTieneExcipientesDeclObligatoria = swTieneExcipientesDeclObligatoria;
    }

    public String getSwTld() {
        return swTld;
    }

    public void setSwTld(String swTld) {
        this.swTld = swTld;
    }

    public String getSwTrianguloNegro() {
        return swTrianguloNegro;
    }

    public void setSwTrianguloNegro(String swTrianguloNegro) {
        this.swTrianguloNegro = swTrianguloNegro;
    }

    public String getSwUsoHospitalario() {
        return swUsoHospitalario;
    }

    public void setSwUsoHospitalario(String swUsoHospitalario) {
        this.swUsoHospitalario = swUsoHospitalario;
    }

    public String getUrlFicTec() {
        return urlFicTec;
    }

    public void setUrlFicTec(String urlFicTec) {
        this.urlFicTec = urlFicTec;
    }

    public String getUrlProsp() {
        return urlProsp;
    }

    public void setUrlProsp(String urlProsp) {
        this.urlProsp = urlProsp;
    }

    public String getCodDcpId() {
        return codDcpId;
    }

    public void setCodDcpId(String codDcpId) {
        this.codDcpId = codDcpId;
    }

    public String getCodDcsaId() {
        return codDcsaId;
    }

    public void setCodDcsaId(String codDcsaId) {
        this.codDcsaId = codDcsaId;
    }

    public String getCodEnvaseId() {
        return codEnvaseId;
    }

    public void setCodEnvaseId(String codEnvaseId) {
        this.codEnvaseId = codEnvaseId;
    }

    public String getCodSitregId() {
        return codSitregId;
    }

    public void setCodSitregId(String codSitregId) {
        this.codSitregId = codSitregId;
    }

    public String getCodigoDcpfId() {
        return codigoDcpfId;
    }

    public void setCodigoDcpfId(String codigoDcpfId) {
        this.codigoDcpfId = codigoDcpfId;
    }

    public String getLaboratorioComercializadorId() {
        return laboratorioComercializadorId;
    }

    public void setLaboratorioComercializadorId(String laboratorioComercializadorId) {
        this.laboratorioComercializadorId = laboratorioComercializadorId;
    }

    public String getLaboratorioTitularId() {
        return laboratorioTitularId;
    }

    public void setLaboratorioTitularId(String laboratorioTitularId) {
        this.laboratorioTitularId = laboratorioTitularId;
    }

    public String getUnidContenidoId() {
        return unidContenidoId;
    }

    public void setUnidContenidoId(String unidContenidoId) {
        this.unidContenidoId = unidContenidoId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.biosimilar);
        hash = 83 * hash + Objects.hashCode(this.codNacionalesInactivos);
        hash = 83 * hash + Objects.hashCode(this.codSitregPresenId);
        hash = 83 * hash + Objects.hashCode(this.contenido);
        hash = 83 * hash + Objects.hashCode(this.desDosific);
        hash = 83 * hash + Objects.hashCode(this.desNomco);
        hash = 83 * hash + Objects.hashCode(this.desPrese);
        hash = 83 * hash + Objects.hashCode(this.fecComer);
        hash = 83 * hash + Objects.hashCode(this.fecSitregPresen);
        hash = 83 * hash + Objects.hashCode(this.fechaAutorizacion);
        hash = 83 * hash + Objects.hashCode(this.fechaSituacionRegistro);
        hash = 83 * hash + Objects.hashCode(this.importacionParalela);
        hash = 83 * hash + Objects.hashCode(this.listaEstupefaciente);
        hash = 83 * hash + Objects.hashCode(this.listaPsicotropo);
        hash = 83 * hash + Objects.hashCode(this.nroConte);
        hash = 83 * hash + Objects.hashCode(this.nroDefinitivo);
        hash = 83 * hash + Objects.hashCode(this.swAfectaConduccion);
        hash = 83 * hash + Objects.hashCode(this.swBaseAPlantas);
        hash = 83 * hash + Objects.hashCode(this.swComercializado);
        hash = 83 * hash + Objects.hashCode(this.swDiagnosticoHospitalario);
        hash = 83 * hash + Objects.hashCode(this.swEnvaseClinico);
        hash = 83 * hash + Objects.hashCode(this.swEspecialControlMedico);
        hash = 83 * hash + Objects.hashCode(this.swEstupefaciente);
        hash = 83 * hash + Objects.hashCode(this.swGenerico);
        hash = 83 * hash + Objects.hashCode(this.swHuerfano);
        hash = 83 * hash + Objects.hashCode(this.swPsicotropo);
        hash = 83 * hash + Objects.hashCode(this.swReceta);
        hash = 83 * hash + Objects.hashCode(this.swSustituible);
        hash = 83 * hash + Objects.hashCode(this.swTieneExcipientesDeclObligatoria);
        hash = 83 * hash + Objects.hashCode(this.swTld);
        hash = 83 * hash + Objects.hashCode(this.swTrianguloNegro);
        hash = 83 * hash + Objects.hashCode(this.swUsoHospitalario);
        hash = 83 * hash + Objects.hashCode(this.urlFicTec);
        hash = 83 * hash + Objects.hashCode(this.urlProsp);
        hash = 83 * hash + Objects.hashCode(this.codDcpId);
        hash = 83 * hash + Objects.hashCode(this.codDcsaId);
        hash = 83 * hash + Objects.hashCode(this.codEnvaseId);
        hash = 83 * hash + Objects.hashCode(this.codSitregId);
        hash = 83 * hash + Objects.hashCode(this.codigoDcpfId);
        hash = 83 * hash + Objects.hashCode(this.laboratorioComercializadorId);
        hash = 83 * hash + Objects.hashCode(this.laboratorioTitularId);
        hash = 83 * hash + Objects.hashCode(this.unidContenidoId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prescripcion other = (Prescripcion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.biosimilar, other.biosimilar)) {
            return false;
        }
        if (!Objects.equals(this.codNacionalesInactivos, other.codNacionalesInactivos)) {
            return false;
        }
        if (!Objects.equals(this.codSitregPresenId, other.codSitregPresenId)) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.desDosific, other.desDosific)) {
            return false;
        }
        if (!Objects.equals(this.desNomco, other.desNomco)) {
            return false;
        }
        if (!Objects.equals(this.desPrese, other.desPrese)) {
            return false;
        }
        if (!Objects.equals(this.importacionParalela, other.importacionParalela)) {
            return false;
        }
        if (!Objects.equals(this.listaEstupefaciente, other.listaEstupefaciente)) {
            return false;
        }
        if (!Objects.equals(this.listaPsicotropo, other.listaPsicotropo)) {
            return false;
        }
        if (!Objects.equals(this.nroConte, other.nroConte)) {
            return false;
        }
        if (!Objects.equals(this.nroDefinitivo, other.nroDefinitivo)) {
            return false;
        }
        if (!Objects.equals(this.swAfectaConduccion, other.swAfectaConduccion)) {
            return false;
        }
        if (!Objects.equals(this.swBaseAPlantas, other.swBaseAPlantas)) {
            return false;
        }
        if (!Objects.equals(this.swComercializado, other.swComercializado)) {
            return false;
        }
        if (!Objects.equals(this.swDiagnosticoHospitalario, other.swDiagnosticoHospitalario)) {
            return false;
        }
        if (!Objects.equals(this.swEnvaseClinico, other.swEnvaseClinico)) {
            return false;
        }
        if (!Objects.equals(this.swEspecialControlMedico, other.swEspecialControlMedico)) {
            return false;
        }
        if (!Objects.equals(this.swEstupefaciente, other.swEstupefaciente)) {
            return false;
        }
        if (!Objects.equals(this.swGenerico, other.swGenerico)) {
            return false;
        }
        if (!Objects.equals(this.swHuerfano, other.swHuerfano)) {
            return false;
        }
        if (!Objects.equals(this.swPsicotropo, other.swPsicotropo)) {
            return false;
        }
        if (!Objects.equals(this.swReceta, other.swReceta)) {
            return false;
        }
        if (!Objects.equals(this.swSustituible, other.swSustituible)) {
            return false;
        }
        if (!Objects.equals(this.swTieneExcipientesDeclObligatoria, other.swTieneExcipientesDeclObligatoria)) {
            return false;
        }
        if (!Objects.equals(this.swTld, other.swTld)) {
            return false;
        }
        if (!Objects.equals(this.swTrianguloNegro, other.swTrianguloNegro)) {
            return false;
        }
        if (!Objects.equals(this.swUsoHospitalario, other.swUsoHospitalario)) {
            return false;
        }
        if (!Objects.equals(this.urlFicTec, other.urlFicTec)) {
            return false;
        }
        if (!Objects.equals(this.urlProsp, other.urlProsp)) {
            return false;
        }
        if (!Objects.equals(this.codDcpId, other.codDcpId)) {
            return false;
        }
        if (!Objects.equals(this.codDcsaId, other.codDcsaId)) {
            return false;
        }
        if (!Objects.equals(this.codEnvaseId, other.codEnvaseId)) {
            return false;
        }
        if (!Objects.equals(this.codSitregId, other.codSitregId)) {
            return false;
        }
        if (!Objects.equals(this.codigoDcpfId, other.codigoDcpfId)) {
            return false;
        }
        if (!Objects.equals(this.laboratorioComercializadorId, other.laboratorioComercializadorId)) {
            return false;
        }
        if (!Objects.equals(this.laboratorioTitularId, other.laboratorioTitularId)) {
            return false;
        }
        if (!Objects.equals(this.unidContenidoId, other.unidContenidoId)) {
            return false;
        }
        if (!Objects.equals(this.fecComer, other.fecComer)) {
            return false;
        }
        if (!Objects.equals(this.fecSitregPresen, other.fecSitregPresen)) {
            return false;
        }
        if (!Objects.equals(this.fechaAutorizacion, other.fechaAutorizacion)) {
            return false;
        }
        return Objects.equals(this.fechaSituacionRegistro, other.fechaSituacionRegistro);
    }

    

    @Override
    public String toString() {
        return "Prescripcion{" + "id=" + id + ", biosimilar=" + biosimilar + ", codNacionalesInactivos=" + codNacionalesInactivos + ", codSitregPresenId=" + codSitregPresenId + ", contenido=" + contenido + ", desDosific=" + desDosific + ", desNomco=" + desNomco + ", desPrese=" + desPrese + ", fecComer=" + fecComer + ", fecSitregPresen=" + fecSitregPresen + ", fechaAutorizacion=" + fechaAutorizacion + ", fechaSituacionRegistro=" + fechaSituacionRegistro + ", importacionParalela=" + importacionParalela + ", listaEstupefaciente=" + listaEstupefaciente + ", listaPsicotropo=" + listaPsicotropo + ", nroConte=" + nroConte + ", nroDefinitivo=" + nroDefinitivo + ", swAfectaConduccion=" + swAfectaConduccion + ", swBaseAPlantas=" + swBaseAPlantas + ", swComercializado=" + swComercializado + ", swDiagnosticoHospitalario=" + swDiagnosticoHospitalario + ", swEnvaseClinico=" + swEnvaseClinico + ", swEspecialControlMedico=" + swEspecialControlMedico + ", swEstupefaciente=" + swEstupefaciente + ", swGenerico=" + swGenerico + ", swHuerfano=" + swHuerfano + ", swPsicotropo=" + swPsicotropo + ", swReceta=" + swReceta + ", swSustituible=" + swSustituible + ", swTieneExcipientesDeclObligatoria=" + swTieneExcipientesDeclObligatoria + ", swTld=" + swTld + ", swTrianguloNegro=" + swTrianguloNegro + ", swUsoHospitalario=" + swUsoHospitalario + ", urlFicTec=" + urlFicTec + ", urlProsp=" + urlProsp + ", codDcpId=" + codDcpId + ", codDcsaId=" + codDcsaId + ", codEnvaseId=" + codEnvaseId + ", codSitregId=" + codSitregId + ", codigoDcpfId=" + codigoDcpfId + ", laboratorioComercializadorId=" + laboratorioComercializadorId + ", laboratorioTitularId=" + laboratorioTitularId + ", unidContenidoId=" + unidContenidoId + '}';
    }
    
    
    
}
