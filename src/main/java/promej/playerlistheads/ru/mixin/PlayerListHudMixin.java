package promej.playerlistheads.ru.mixin;

import net.minecraft.client.MinecraftClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.PlayerListHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerListHud.class)
public abstract class PlayerListHudMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;isLocalPlayer()Z"))
    private boolean renderHeads(MinecraftClient instance) {
        // Certifique-se de que este código só é executado no cliente
        if (instance.isInSingleplayer()) {
            return true;
        }
        return false; // Lógica padrão no servidor
    }
}
