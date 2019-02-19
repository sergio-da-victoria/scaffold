package br.com.open.eip.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;



@NamedQueries({  
	@NamedQuery(name = "find.bydIdProduto",  query  = "SELECT p FROM Produto AS p WHERE p.seqproduto =:seqproduto"),
	@NamedQuery(name = "find.byNameProduto", query  = "SELECT p FROM Produto AS p WHERE p.desccompleta =:desccompleta"),
	@NamedQuery(name = "find.delete",        query  = "DELETE FROM Produto AS p"),
	@NamedQuery(name = "find.allProduto",    query  = "SELECT p FROM Produto AS p")
})



@Entity(name="Produto")
@Table(name="produto")
@XmlRootElement
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "seqproduto", length = 38)
	private Integer seqproduto;
	
		
	@Column(name = "complemento", length = 50)
	private String complemento;
	
	@Column(name = "desccompleta", length = 50)
	private String desccompleta;
	
	@Column(name = "descgenerica", length = 60)
	private String descgenerica;
	
	@Column(name = "descreduzida", length = 24)
	private String descreduzida;
	
	@Column(name = "indprecozerobalanca", length = 1)
	private String indprecozerobalanca;
	
	@Column(name = "pzovalidademes", length = 4)
	private Integer pzovalidademes;
	
	@Column(name = "pzovalidadedia", length = 4)
	private Integer pzovalidadedia;
	
	@Column(name = "reffabricante", length = 20)
	private String reffabricante;
	
	@Column(name = "seqinfnutricprod", length = 38)
	private Integer seqinfnutricprod;
	
	@Column(name = "impdatavalidadebalanc", length = 1)
	private String impdatavalidadebalanc;
	
	@Column(name = "impdataembbalanc", length = 1)
	private String impdataembbalanc;
	
	@Column(name = "nroregminsaude", length = 30)
	private String nroregminsaude;
	
	@Column(name = "ESPECIFICDETALHADA", length = 2000)
	private String especificdetalhada;
	
	@Column(name = "indusanfdespesa", length = 1)
	private String indusanfdespesa;
	
	@Column(name = "nroitemfixo", length = 3)
	private Integer nroitemfixo;
	
	@Column(name = "nrodiasadverrecbto", length = 4)
	private Integer nrodiasadverrecbto;
	
	@Column(name = "seqprodutobase", length = 38)
	private Integer seqprodutobase;
	
	@Column(name = "percacrespreco", precision = 5, scale = 2)
	private BigDecimal percacrespreco;
	
	@Column(name = "percaltprecrelac", precision = 5, scale = 3)
	private BigDecimal percaltprecrelac;
	
	@Column(name = "propqtdprodutobase", precision = 8, scale = 6)
	private BigDecimal propqtdprodutobase;
	
	@Column(name = "codprodfiscal", length = 1)
	private String codprodfiscal;
	
	@Column(name = "qtdfabricadalote", precision = 12, scale = 3)
	private BigDecimal qtdfabricadalote;
	
	@Column(name = "desccomposicao", length = 2000)
	private String desccomposicao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dtahoralteracao")
	private java.util.Date dtahoralteracao;
	
	@Column(name = "usuarioalteracao", length = 12)
	private String usuarioalteracao;
	
	@Column(name = "usuarioinclusao", length = 12)
	private String usuarioinclusao;
	
	@Column(name = "indprocfabricacao", length = 1)
	private String indprocfabricacao;
	
	@Column(name = "indreplicacao", length = 1)
	private String indreplicacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dtahorinclusao")
	private java.util.Date dtahorinclusao;
	
	@Column(name = "geralivrocprod", length = 1)
	private String geralivrocprod;
	
	
	@Column(name = "indemitecodprodfiscalnfe", length = 1)
	private String indemitecodprodfiscalnfe;
	
	@Column(name = "codigoanp", length = 9)
	private Integer codigoanp;
	
	@Column(name = "codigoif", length = 21)
	private Integer codigoif;
	
	@Column(name = "qtdlimitepromocecommerce", precision = 12, scale = 3)
	private BigDecimal qtdlimitepromocecommerce;
	
	@Column(name = "youtubecodeecommerce", length = 1)
	private String youtubecodeecommerce;
	
	@Column(name = "datahorintegracaoecommerce", length = 50)
	private java.util.Date datahorintegracaoecommerce;
	
	@Column(name = "indintegraecommerce", length = 1)
	private String indintegraecommerce;
	
	
	@Column(name = "tituloecommerce", length = 200)
	private String tituloecommerce;
	
	@Column(name = "descecommerce", length = 500)
	private String descecommerce;


	@Column(name = "percgasnatural", precision = 12, scale = 3)
	private String percgasnatural;

	@Column(name = "indemiteetqhort", length = 1)
	private String indemiteetqhort;
	               
	@Column(name = "palavrachaveecommerce", length = 500)
	private String palavrachaveecommerce;
	
	

	public Integer getSeqproduto() {
		return seqproduto;
	}

	public void setSeqproduto(Integer seqproduto) {
		this.seqproduto = seqproduto;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDesccompleta() {
		return desccompleta;
	}

	public void setDesccompleta(String desccompleta) {
		this.desccompleta = desccompleta;
	}

	public String getDescgenerica() {
		return descgenerica;
	}

	public void setDescgenerica(String descgenerica) {
		this.descgenerica = descgenerica;
	}

	public String getDescreduzida() {
		return descreduzida;
	}

	public void setDescreduzida(String descreduzida) {
		this.descreduzida = descreduzida;
	}

	public String getIndprecozerobalanca() {
		return indprecozerobalanca;
	}

	public void setIndprecozerobalanca(String indprecozerobalanca) {
		this.indprecozerobalanca = indprecozerobalanca;
	}

	public Integer getPzovalidademes() {
		return pzovalidademes;
	}

	public void setPzovalidademes(Integer pzovalidademes) {
		this.pzovalidademes = pzovalidademes;
	}

	public Integer getPzovalidadedia() {
		return pzovalidadedia;
	}

	public void setPzovalidadedia(Integer pzovalidadedia) {
		this.pzovalidadedia = pzovalidadedia;
	}

	public String getReffabricante() {
		return reffabricante;
	}

	public void setReffabricante(String reffabricante) {
		this.reffabricante = reffabricante;
	}

	public Integer getSeqinfnutricprod() {
		return seqinfnutricprod;
	}

	public void setSeqinfnutricprod(Integer seqinfnutricprod) {
		this.seqinfnutricprod = seqinfnutricprod;
	}

	public String getImpdatavalidadebalanc() {
		return impdatavalidadebalanc;
	}

	public void setImpdatavalidadebalanc(String impdatavalidadebalanc) {
		this.impdatavalidadebalanc = impdatavalidadebalanc;
	}

	public String getImpdataembbalanc() {
		return impdataembbalanc;
	}

	public void setImpdataembbalanc(String impdataembbalanc) {
		this.impdataembbalanc = impdataembbalanc;
	}

	public String getNroregminsaude() {
		return nroregminsaude;
	}

	public void setNroregminsaude(String nroregminsaude) {
		this.nroregminsaude = nroregminsaude;
	}

	public String getEspecificdetalhada() {
		return especificdetalhada;
	}

	public void setEspecificdetalhada(String especificdetalhada) {
		this.especificdetalhada = especificdetalhada;
	}

	public String getIndusanfdespesa() {
		return indusanfdespesa;
	}

	public void setIndusanfdespesa(String indusanfdespesa) {
		this.indusanfdespesa = indusanfdespesa;
	}

	public Integer getNroitemfixo() {
		return nroitemfixo;
	}

	public void setNroitemfixo(Integer nroitemfixo) {
		this.nroitemfixo = nroitemfixo;
	}

	public Integer getNrodiasadverrecbto() {
		return nrodiasadverrecbto;
	}

	public void setNrodiasadverrecbto(Integer nrodiasadverrecbto) {
		this.nrodiasadverrecbto = nrodiasadverrecbto;
	}

	public Integer getSeqprodutobase() {
		return seqprodutobase;
	}

	public void setSeqprodutobase(Integer seqprodutobase) {
		this.seqprodutobase = seqprodutobase;
	}

	public BigDecimal getPercacrespreco() {
		return percacrespreco;
	}

	public void setPercacrespreco(BigDecimal percacrespreco) {
		this.percacrespreco = percacrespreco;
	}

	public BigDecimal getPercaltprecrelac() {
		return percaltprecrelac;
	}

	public void setPercaltprecrelac(BigDecimal percaltprecrelac) {
		this.percaltprecrelac = percaltprecrelac;
	}

	public BigDecimal getPropqtdprodutobase() {
		return propqtdprodutobase;
	}

	public void setPropqtdprodutobase(BigDecimal propqtdprodutobase) {
		this.propqtdprodutobase = propqtdprodutobase;
	}

	public String getCodprodfiscal() {
		return codprodfiscal;
	}

	public void setCodprodfiscal(String codprodfiscal) {
		this.codprodfiscal = codprodfiscal;
	}

	public BigDecimal getQtdfabricadalote() {
		return qtdfabricadalote;
	}

	public void setQtdfabricadalote(BigDecimal qtdfabricadalote) {
		this.qtdfabricadalote = qtdfabricadalote;
	}

	public String getDesccomposicao() {
		return desccomposicao;
	}

	public void setDesccomposicao(String desccomposicao) {
		this.desccomposicao = desccomposicao;
	}

	public java.util.Date getDtahoralteracao() {
		return dtahoralteracao;
	}

	public void setDtahoralteracao(java.util.Date dtahoralteracao) {
		this.dtahoralteracao = dtahoralteracao;
	}

	public String getUsuarioalteracao() {
		return usuarioalteracao;
	}

	public void setUsuarioalteracao(String usuarioalteracao) {
		this.usuarioalteracao = usuarioalteracao;
	}

	public String getUsuarioinclusao() {
		return usuarioinclusao;
	}

	public void setUsuarioinclusao(String usuarioinclusao) {
		this.usuarioinclusao = usuarioinclusao;
	}

	public String getIndprocfabricacao() {
		return indprocfabricacao;
	}

	public void setIndprocfabricacao(String indprocfabricacao) {
		this.indprocfabricacao = indprocfabricacao;
	}

	public String getIndreplicacao() {
		return indreplicacao;
	}

	public void setIndreplicacao(String indreplicacao) {
		this.indreplicacao = indreplicacao;
	}

	public java.util.Date getDtahorinclusao() {
		return dtahorinclusao;
	}

	public void setDtahorinclusao(java.util.Date dtahorinclusao) {
		this.dtahorinclusao = dtahorinclusao;
	}

	public String getGeralivrocprod() {
		return geralivrocprod;
	}

	public void setGeralivrocprod(String geralivrocprod) {
		this.geralivrocprod = geralivrocprod;
	}

	public String getIndemitecodprodfiscalnfe() {
		return indemitecodprodfiscalnfe;
	}

	public void setIndemitecodprodfiscalnfe(String indemitecodprodfiscalnfe) {
		this.indemitecodprodfiscalnfe = indemitecodprodfiscalnfe;
	}

	public Integer getCodigoanp() {
		return codigoanp;
	}

	public void setCodigoanp(Integer codigoanp) {
		this.codigoanp = codigoanp;
	}

	public Integer getCodigoif() {
		return codigoif;
	}

	public void setCodigoif(Integer codigoif) {
		this.codigoif = codigoif;
	}

	public BigDecimal getQtdlimitepromocecommerce() {
		return qtdlimitepromocecommerce;
	}

	public void setQtdlimitepromocecommerce(BigDecimal qtdlimitepromocecommerce) {
		this.qtdlimitepromocecommerce = qtdlimitepromocecommerce;
	}

	public String getYoutubecodeecommerce() {
		return youtubecodeecommerce;
	}

	public void setYoutubecodeecommerce(String youtubecodeecommerce) {
		this.youtubecodeecommerce = youtubecodeecommerce;
	}

	public java.util.Date getDatahorintegracaoecommerce() {
		return datahorintegracaoecommerce;
	}

	public void setDatahorintegracaoecommerce(java.util.Date datahorintegracaoecommerce) {
		this.datahorintegracaoecommerce = datahorintegracaoecommerce;
	}

	public String getIndintegraecommerce() {
		return indintegraecommerce;
	}

	public void setIndintegraecommerce(String indintegraecommerce) {
		this.indintegraecommerce = indintegraecommerce;
	}

	public String getTituloecommerce() {
		return tituloecommerce;
	}

	public void setTituloecommerce(String tituloecommerce) {
		this.tituloecommerce = tituloecommerce;
	}

	public String getDescecommerce() {
		return descecommerce;
	}

	public void setDescecommerce(String descecommerce) {
		this.descecommerce = descecommerce;
	}

	public String getPercgasnatural() {
		return percgasnatural;
	}

	public void setPercgasnatural(String percgasnatural) {
		this.percgasnatural = percgasnatural;
	}

	public String getIndemiteetqhort() {
		return indemiteetqhort;
	}

	public void setIndemiteetqhort(String indemiteetqhort) {
		this.indemiteetqhort = indemiteetqhort;
	}

	public String getPalavrachaveecommerce() {
		return palavrachaveecommerce;
	}

	public void setPalavrachaveecommerce(String palavrachaveecommerce) {
		this.palavrachaveecommerce = palavrachaveecommerce;
	}
	

	@Override
	public String toString() {
		return "Produto [seqproduto=" + seqproduto + ", complemento=" + complemento + ", desccompleta=" + desccompleta
				+ ", descgenerica=" + descgenerica + ", descreduzida=" + descreduzida + ", indprecozerobalanca="
				+ indprecozerobalanca + ", pzovalidademes=" + pzovalidademes + ", pzovalidadedia=" + pzovalidadedia
				+ ", reffabricante=" + reffabricante + ", seqinfnutricprod=" + seqinfnutricprod
				+ ", impdatavalidadebalanc=" + impdatavalidadebalanc + ", impdataembbalanc=" + impdataembbalanc
				+ ", nroregminsaude=" + nroregminsaude + ", especificdetalhada=" + especificdetalhada
				+ ", indusanfdespesa=" + indusanfdespesa + ", nroitemfixo=" + nroitemfixo + ", nrodiasadverrecbto="
				+ nrodiasadverrecbto + ", seqprodutobase=" + seqprodutobase + ", percacrespreco=" + percacrespreco
				+ ", percaltprecrelac=" + percaltprecrelac + ", propqtdprodutobase=" + propqtdprodutobase
				+ ", codprodfiscal=" + codprodfiscal + ", qtdfabricadalote=" + qtdfabricadalote + ", desccomposicao="
				+ desccomposicao + ", dtahoralteracao=" + dtahoralteracao + ", usuarioalteracao=" + usuarioalteracao
				+ ", usuarioinclusao=" + usuarioinclusao + ", indprocfabricacao=" + indprocfabricacao
				+ ", indreplicacao=" + indreplicacao + ", dtahorinclusao=" + dtahorinclusao + ", geralivrocprod="
				+ geralivrocprod + ", indemitecodprodfiscalnfe=" + indemitecodprodfiscalnfe + ", codigoanp=" + codigoanp
				+ ", codigoif=" + codigoif + ", qtdlimitepromocecommerce=" + qtdlimitepromocecommerce
				+ ", youtubecodeecommerce=" + youtubecodeecommerce + ", datahorintegracaoecommerce="
				+ datahorintegracaoecommerce + ", indintegraecommerce=" + indintegraecommerce + ", tituloecommerce="
				+ tituloecommerce + ", descecommerce=" + descecommerce + ", percgasnatural=" + percgasnatural
				+ ", indemiteetqhort=" + indemiteetqhort + ", palavrachaveecommerce=" + palavrachaveecommerce + "]";
	}
	
	
	
	

	
}	
