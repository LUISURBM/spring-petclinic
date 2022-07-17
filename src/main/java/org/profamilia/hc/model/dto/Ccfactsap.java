package org.profamilia.hc.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */

public class Ccfactsap implements java.io.Serializable {

	private BigDecimal cfsnnumero;
	private BigDecimal cfsnnumfac;
	private Integer cfsnclinic;
	private Date cfsdfecreg;
	private String cfscusuari;
	private Integer cfsncontra;
	private Integer cfsnprogra;
	private BigDecimal cfsasubtot;
	private BigDecimal cfsaabono;
	private String cfscpacien;
	private BigDecimal cfsaiva;
	private BigDecimal cfsadescto;
	private BigDecimal cfsavalent;
	private Integer cfsnestado;
	private String cfsctipide;
	private BigDecimal cfsanumide;
	private Date cfsdfecrem;
	private String cfscremite;
	private BigDecimal cfsndonant;
	private String cfscgenero;
	private String cfscnumrem;
	private BigDecimal cfsavaldon;
	private BigDecimal cfslusuario;
	private Integer version;
	private String cfscclafac;
	private Date cfsdfecanu;
	private String cfscnumanu;

	public final String getCfscclafac() {
		return cfscclafac;
	}

	public final void setCfscclafac(String cfscclafac) {
		this.cfscclafac = cfscclafac;
	}

	public final Date getCfsdfecanu() {
		return cfsdfecanu;
	}

	public final void setCfsdfecanu(Date cfsdfecanu) {
		this.cfsdfecanu = cfsdfecanu;
	}

	public final String getCfscnumanu() {
		return cfscnumanu;
	}

	public final void setCfscnumanu(String cfscnumanu) {
		this.cfscnumanu = cfscnumanu;
	}

	/**
	 * @return the version
	 */
	public final Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public final void setVersion(Integer version) {
		this.version = version;
	}

	// Constructors

	/** default constructor */
	public Ccfactsap() {
	}

	/** constructor with id */
	// HS == Integer

	public Ccfactsap(BigDecimal cfsnnumero) {
		this.cfsnnumero = cfsnnumero;
	}

	// HS SEPARADOR CONSTRUCTOR

	// Property accessors

	public BigDecimal getCfsnnumero() {
		return this.cfsnnumero;
	}

	public void setCfsnnumero(BigDecimal cfsnnumero) {
		this.cfsnnumero = cfsnnumero;
	}

	public BigDecimal getCfsnnumfac() {
		return this.cfsnnumfac;
	}

	public void setCfsnnumfac(BigDecimal cfsnnumfac) {
		this.cfsnnumfac = cfsnnumfac;
	}

	public Integer getCfsnclinic() {
		return this.cfsnclinic;
	}

	public void setCfsnclinic(Integer cfsnclinic) {
		this.cfsnclinic = cfsnclinic;
	}

	public Date getCfsdfecreg() {
		return this.cfsdfecreg;
	}

	public void setCfsdfecreg(Date cfsdfecreg) {
		this.cfsdfecreg = cfsdfecreg;
	}

	public String getCfscusuari() {
		return this.cfscusuari;
	}

	public void setCfscusuari(String cfscusuari) {
		this.cfscusuari = cfscusuari;
	}

	public Integer getCfsncontra() {
		return this.cfsncontra;
	}

	public void setCfsncontra(Integer cfsncontra) {
		this.cfsncontra = cfsncontra;
	}

	public Integer getCfsnprogra() {
		return this.cfsnprogra;
	}

	public void setCfsnprogra(Integer cfsnprogra) {
		this.cfsnprogra = cfsnprogra;
	}

	public BigDecimal getCfsasubtot() {
		return this.cfsasubtot;
	}

	public void setCfsasubtot(BigDecimal cfsasubtot) {
		this.cfsasubtot = cfsasubtot;
	}

	public BigDecimal getCfsaabono() {
		return this.cfsaabono;
	}

	public void setCfsaabono(BigDecimal cfsaabono) {
		this.cfsaabono = cfsaabono;
	}

	public String getCfscpacien() {
		return this.cfscpacien;
	}

	public void setCfscpacien(String cfscpacien) {
		this.cfscpacien = cfscpacien;
	}

	public BigDecimal getCfsaiva() {
		return this.cfsaiva;
	}

	public void setCfsaiva(BigDecimal cfsaiva) {
		this.cfsaiva = cfsaiva;
	}

	public BigDecimal getCfsadescto() {
		return this.cfsadescto;
	}

	public void setCfsadescto(BigDecimal cfsadescto) {
		this.cfsadescto = cfsadescto;
	}

	public BigDecimal getCfsavalent() {
		return this.cfsavalent;
	}

	public void setCfsavalent(BigDecimal cfsavalent) {
		this.cfsavalent = cfsavalent;
	}

	public Integer getCfsnestado() {
		return this.cfsnestado;
	}

	public void setCfsnestado(Integer cfsnestado) {
		this.cfsnestado = cfsnestado;
	}

	public String getCfsctipide() {
		return this.cfsctipide;
	}

	public void setCfsctipide(String cfsctipide) {
		this.cfsctipide = cfsctipide;
	}

	public BigDecimal getCfsanumide() {
		return this.cfsanumide;
	}

	public void setCfsanumide(BigDecimal cfsanumide) {
		this.cfsanumide = cfsanumide;
	}

	public Date getCfsdfecrem() {
		return this.cfsdfecrem;
	}

	public void setCfsdfecrem(Date cfsdfecrem) {
		this.cfsdfecrem = cfsdfecrem;
	}

	public String getCfscremite() {
		return this.cfscremite;
	}

	public void setCfscremite(String cfscremite) {
		this.cfscremite = cfscremite;
	}

	public final BigDecimal getCfsndonant() {
		return cfsndonant;
	}

	public final void setCfsndonant(BigDecimal cfsndonant) {
		this.cfsndonant = cfsndonant;
	}

	public String getCfscgenero() {
		return this.cfscgenero;
	}

	public void setCfscgenero(String cfscgenero) {
		this.cfscgenero = cfscgenero;
	}

	public String getCfscnumrem() {
		return this.cfscnumrem;
	}

	public void setCfscnumrem(String cfscnumrem) {
		this.cfscnumrem = cfscnumrem;
	}

	public BigDecimal getCfsavaldon() {
		return this.cfsavaldon;
	}

	public void setCfsavaldon(BigDecimal cfsavaldon) {
		this.cfsavaldon = cfsavaldon;
	}

	public BigDecimal getCfslusuario() {
		return cfslusuario;
	}

	public void setCfslusuario(BigDecimal cfslusuario) {
		this.cfslusuario = cfslusuario;
	}

	
	// no tiene llave compuesta.

}
