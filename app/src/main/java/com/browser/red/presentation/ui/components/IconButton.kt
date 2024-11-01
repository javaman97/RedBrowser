package com.browser.red.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun IconButtonPreview(){
    IconButton(
        imageVector = Icons.Default.Face,
        tint = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun IconButton(
    imageVector: ImageVector? = null,
    painter: Painter? = null,
    contentDescription:String = "",
    size: DpSize = DpSize(width = 32.dp, height = 32.dp),
    tint:Color? = null,
    caption:String = "",
    fontSize:TextUnit = 14.sp,
    onClick:()->Unit = {}
    ){
    Box(
        modifier = Modifier
            .size(size)
            .clickable { onClick()},
        contentAlignment = Alignment.Center
    ){
        if(painter != null){
            Icon(
                modifier = Modifier

                    .fillMaxSize(),
                painter = painter,
                contentDescription = contentDescription,
                tint = tint ?: MaterialTheme.colorScheme.onPrimaryContainer
            )
        } else if(imageVector != null){
            Icon(
                modifier = Modifier

                    .fillMaxSize(),
                imageVector = imageVector,
                contentDescription = contentDescription,
                tint = tint ?: MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        if(caption.isNotEmpty()){
            Text(
                text = caption,
                modifier = Modifier
                    .align(Alignment.Center),
                color = tint ?: MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = fontSize
            )
        }
    }

}