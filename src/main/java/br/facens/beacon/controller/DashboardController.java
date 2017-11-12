package br.facens.beacon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.facens.beacon.enums.AcaoEnum;
import br.facens.beacon.model.AcaoModel;
import br.facens.beacon.model.BeaconModel;
import br.facens.beacon.model.HistoricoLocalizacaoBeaconModel;
import br.facens.beacon.model.LocalizacaoModel;
import br.facens.beacon.model.UsuarioModel;
import br.facens.beacon.repository.AcaoRepository;
import br.facens.beacon.repository.BeaconRepository;
import br.facens.beacon.repository.HistoricoLocalizacaoBeaconRepository;
import br.facens.beacon.repository.LocalizacaoRepository;
import br.facens.beacon.repository.UsuarioRepository;

@Controller
@RequestMapping
public class DashboardController {

	@Autowired
	private BeaconRepository beaconRepository;

	@Autowired
	private LocalizacaoRepository localizacaoRepository;

	@Autowired
	private HistoricoLocalizacaoBeaconRepository historicoLocalizacaoBeaconRepository;
	
	@Autowired
	private AcaoRepository acaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ModelAndView paginaInicial() {
		List<BeaconModel> beacons = beaconRepository.findAll();
		List<UsuarioModel> usuarios = usuarioRepository.findAll();
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("beacons", beacons);
		mv.addObject("usuarios", usuarios);
		return mv;
	}

	@GetMapping("popularBanco")
	public String popularBanco() {
		
		if (!acaoRepository.findAll().isEmpty()) {
			return "redirect:";
		}
		
		UsuarioModel usr1 = new UsuarioModel();
		usr1.setLogin("Francis");
		UsuarioModel usr2 = new UsuarioModel();
		usr2.setLogin("Ricardo");
		usuarioRepository.save(usr1);
		usuarioRepository.save(usr2);
		
		LocalizacaoModel loc = new LocalizacaoModel();
		loc.setDescricao("Casa do Francis");
		loc.setLatitude(-23.476790);
		loc.setLongitude(-47.435653);
		localizacaoRepository.save(loc);
		
		AcaoModel ac1 = new AcaoModel();
		ac1.setAcao(AcaoEnum.EXIBIR_MENSAGEM);
		ac1.setInformacaoExtra("Mensagem associada a acão do beacon 1");
		acaoRepository.save(ac1);

		BeaconModel b1 = new BeaconModel();
		b1.setDescricao("iBeacon 1");
		b1.setUuid("2496241f-d7b3-4a7b-8f7c-8d4cb600bd80");
		b1.setMajor(52766);
		b1.setMinor(13);
		b1.setLocalizacaoAtual(loc);
		b1.setAcaoAssociada(ac1);
		BeaconModel b2 = new BeaconModel();
		b2.setDescricao("iBeacon 2");
		b2.setUuid("64657665-6c6f-7064-6279-6d656e766961");
		b2.setMajor(52766);
		b2.setMinor(31);
		b2.setLocalizacaoAtual(loc);
		beaconRepository.save(b1);
		beaconRepository.save(b2);

		HistoricoLocalizacaoBeaconModel hist1 = new HistoricoLocalizacaoBeaconModel();
		hist1.setDesde(new Date());
		hist1.setBeacon(b1);
		hist1.setLocalizacao(loc);
		HistoricoLocalizacaoBeaconModel hist2 = new HistoricoLocalizacaoBeaconModel();
		hist2.setDesde(new Date());
		hist2.setBeacon(b2);
		hist2.setLocalizacao(loc);
		historicoLocalizacaoBeaconRepository.save(hist1);
		historicoLocalizacaoBeaconRepository.save(hist2);

		return "redirect:";
	}
}