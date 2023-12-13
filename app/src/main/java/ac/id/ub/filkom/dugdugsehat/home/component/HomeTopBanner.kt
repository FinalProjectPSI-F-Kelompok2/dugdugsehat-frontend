package ac.id.ub.filkom.dugdugsehat.home.component

import ac.id.ub.filkom.dugdugsehat.R
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


    @Composable
    fun HomeTopBanner(
        userFullName: String,
        modifier: Modifier = Modifier
    ) {
        Row (
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = modifier.weight(3f)
            ) {
                Text(
                    text = stringResource(R.string.hello) + ",",
                    style = Type.heading3Medium()
                )
                Text(
                    text = userFullName,
                    style = Type.heading1Bold(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
