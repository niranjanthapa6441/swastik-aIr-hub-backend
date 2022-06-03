package com.swastikairhub.SwastiKAirHubBackend.DTO;

import com.swastikairhub.SwastiKAirHubBackend.Domain.BaggagePolicy;
import com.swastikairhub.SwastiKAirHubBackend.Domain.CancellationPolicy;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDTO {
    private int id;
    private String ticketCode;
    private int price;
    private String Status;
    private CancellationPolicy cancellationPolicy;
    private BaggagePolicy baggagePolicy;

}
