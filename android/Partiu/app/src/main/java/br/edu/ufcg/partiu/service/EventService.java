package br.edu.ufcg.partiu.service;

import br.edu.ufcg.partiu.model.Event;
import br.edu.ufcg.partiu.base.ServiceCallback;

/**
 * Created by ordan on 29/07/17.
 */

public interface EventService {

    Void createEvent(Event event, ServiceCallback<Event> callback);

}
