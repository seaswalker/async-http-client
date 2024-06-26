/*
 *    Copyright (c) 2015-2023 AsyncHttpClient Project. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.asynchttpclient.netty.request.body;

import io.netty.buffer.ByteBuf;

public class NettyByteBufBody extends NettyDirectBody {

    private final ByteBuf bb;
    private final CharSequence contentTypeOverride;
    private final long length;

    public NettyByteBufBody(ByteBuf bb) {
        this(bb, null);
    }

    public NettyByteBufBody(ByteBuf bb, CharSequence contentTypeOverride) {
        this.bb = bb;
        length = bb.readableBytes();
        this.contentTypeOverride = contentTypeOverride;
    }

    @Override
    public long getContentLength() {
        return length;
    }

    @Override
    public CharSequence getContentTypeOverride() {
        return contentTypeOverride;
    }

    @Override
    public ByteBuf byteBuf() {
        return bb;
    }
}
