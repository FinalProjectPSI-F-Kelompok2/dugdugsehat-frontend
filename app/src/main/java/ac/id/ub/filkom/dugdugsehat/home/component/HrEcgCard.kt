package ac.id.ub.filkom.dugdugsehat.home.component

import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary300
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary700
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import ac.id.ub.filkom.dugdugsehat.ui.theme.largeSpace
import ac.id.ub.filkom.dugdugsehat.ui.theme.mediumSpace
import ac.id.ub.filkom.dugdugsehat.ui.theme.smallSpace
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.processNextEventInCurrentThread

@Composable
fun HrEcgCard(
    value: Int,
    cardColor: Color,
    contentColor: Color,
    cardTitle: String,
    unit: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(mediumSpace),
        elevation = 4.dp,
        backgroundColor = cardColor
    ) {
        Column(
            modifier = modifier
        ) {
            Spacer(modifier = Modifier.height(mediumSpace))
            Row(
                modifier = Modifier
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(contentColor)
                )
                Spacer(modifier = Modifier.width(smallSpace))
                Text(
                    text = cardTitle,
                    style = Type.body3Medium(),
                    color = contentColor
                )
            }
            Spacer(modifier = Modifier.height(mediumSpace))
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = value.toString(),
                    style = Type.heading1Bold(),
                    color = contentColor
                )
                Text(
                    text = unit,
                    style = Type.body3Regular(),
                    color = contentColor,
                    modifier = Modifier
                        .padding(start = smallSpace, bottom = smallSpace)
                )
            }
            Spacer(modifier = Modifier.height(mediumSpace))
        }
    }
}