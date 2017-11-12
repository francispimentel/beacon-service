package br.facens.beacon.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.beacon.model.BeaconModel;
import br.facens.beacon.model.HistoricoLocalizacaoBeaconModel;
import br.facens.beacon.model.LocalizacaoModel;
import br.facens.beacon.repository.BeaconRepository;
import br.facens.beacon.repository.HistoricoLocalizacaoBeaconRepository;
import br.facens.beacon.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {

	@Autowired
	private BeaconRepository beaconRepository;

	@Autowired
	private LocalizacaoRepository localizacaoRepository;

	@Autowired
	private HistoricoLocalizacaoBeaconRepository historicoLocalizacaoBeaconRepository;

	public void alterarLocalizacaoBeacon(Long beaconID, Long localID) {
		BeaconModel b = beaconRepository.findOne(beaconID);
		LocalizacaoModel l = localizacaoRepository.findOne(localID);

		if (b == null || l == null || l.getId().equals(b.getLocalizacaoAtual().getId())) {
			return;
		}

		List<HistoricoLocalizacaoBeaconModel> historico = historicoLocalizacaoBeaconRepository
				.findByBeaconAndLocalizacao(b, b.getLocalizacaoAtual());
		for (HistoricoLocalizacaoBeaconModel h : historico) {
			h.setAte(new Date());
			historicoLocalizacaoBeaconRepository.save(h);
		}

		HistoricoLocalizacaoBeaconModel h = new HistoricoLocalizacaoBeaconModel();
		h.setDesde(new Date());
		h.setBeacon(b);
		h.setLocalizacao(l);
		historicoLocalizacaoBeaconRepository.save(h);

		b.setLocalizacaoAtual(l);
		beaconRepository.save(b);
	}

}
