/**
 *  @author Yunxiang He
 *  @date 06/29/2019
 */

package dataAccess.jdbc.popg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.TreeMap;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class PreOrderableAsinInfo {
    private Timestamp releaseDate;
    private TreeMap<Timestamp, Double> priceInfo;
}