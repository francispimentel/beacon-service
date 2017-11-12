package br.facens.beacon.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.beacon.dto.UsuarioBeaconDto;
import br.facens.beacon.model.BeaconModel;
import br.facens.beacon.model.HistoricoLocalizacaoUsuarioModel;
import br.facens.beacon.model.UsuarioModel;
import br.facens.beacon.repository.BeaconRepository;
import br.facens.beacon.repository.HistoricoLocalizacaoUsuarioRepository;
import br.facens.beacon.repository.UsuarioRepository;

@Service
public class BeaconService {

	@Autowired
	private BeaconRepository beaconRepository;

	@Autowired
	private HistoricoLocalizacaoUsuarioRepository historicoLocalizacaoUsuarioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioBeaconDto registrarBeaconsVistos(UsuarioBeaconDto req) {
		UsuarioModel usuario = usuarioRepository.findOne(req.getUsuario());
		if (usuario == null) {
			return null;
		}

		List<BeaconModel> novos = new ArrayList<BeaconModel>();
		if (req.getBeacons() != null) {
			for (BeaconModel b : req.getBeacons()) {
				if (b == null || b.getUuid() == null) {
					continue;
				}
				List<BeaconModel> busca = beaconRepository.findByUuid(b.getUuid());
				if (busca != null && !busca.isEmpty()) {
					novos.add(busca.get(0));
					registrarBeaconVisto(usuario, busca.get(0));
				}
			}
		}

		req.setBeacons(novos);
		return req;
	}

	private void registrarBeaconVisto(UsuarioModel usuario, BeaconModel beacon) {
		HistoricoLocalizacaoUsuarioModel h = new HistoricoLocalizacaoUsuarioModel();
		h.setUsuario(usuario);
		h.setBeacon(beacon);
		h.setLocalizacao(beacon.getLocalizacaoAtual());
		h.setData(new Date());
		historicoLocalizacaoUsuarioRepository.save(h);
	}
}