package pl.ajonx.wolfsk2.objects.inventory;

import ch.njol.skript.aliases.ItemType;
import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class InventoryElements {

    public static void RegisterInventoryEffects() {

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Initialize")
                .desc("# Initialize inventory")
                .example("new Inventory [id];")
                .usage(new String[]{
                        "new Inventory %string%[;]"
                }), New.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Row")
                .desc("# Set row")
                .example("[Object].setRow{[number]};")
                .usage(new String[]{
                        "%string%.Inventory.setRow{%number%}[;]"
                }), Row.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Item")
                .desc("# Set item")
                .example("[Object].setItem{[number], [itemtype]};")
                .usage(new String[]{
                        "%string%.Inventory.setItem{%number%,%itemtype%}[;]"
                }), Item.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Lore")
                .desc("# Set lore")
                .example("[Object].setLore{[number], [text]};")
                .usage(new String[]{
                        "%string%.Inventory.setLore{%number%,%string%}[;]"
                }), Lore.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Command")
                .desc("# Set command")
                .example("[Object].setCommand{[number], [text]};")
                .usage(new String[]{
                        "%string%.Inventory.setCommand{%number%,%string%}[;]"
                }), Command.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Executor")
                .desc("# Set executor")
                .example("[Object].setExecutor{[number], [text - ''player''/''console'']};")
                .usage(new String[]{
                        "%string%.Inventory.setExecutor{%number%,%string%}[;]"
                }), Executor.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Cancelled")
                .desc("# Set cancelled")
                .example("[Object].setCancelled{[number], [boolean]};")
                .usage(new String[]{
                        "%string%.Inventory.setCancelled{%number%,%boolean%}[;]"
                }), Cancelled.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Closed")
                .desc("# Set closed")
                .example("[Object].setClosed{[number], [boolean]};")
                .usage(new String[]{
                        "%string%.Inventory.setClosed{%number%,%boolean%}[;]"
                }), Closed.class);

        // Do [...]

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Display")
                .desc("# Display inventory for player")
                .example("[Object].display{[player]};")
                .usage(new String[]{
                        "%string%.Inventory.display{%player%}[;]"
                }), Display.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Update")
                .desc("# Update inventory object")
                .example("[Object].update{};")
                .usage(new String[]{
                        "%string%.Inventory.update{}[;]"
                }), Update.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Unregister")
                .desc("# Unregister inventory")
                .example("[Object].unregister{};")
                .usage(new String[]{
                        "%string%.Inventory.unregister{}[;]"
                }), UnRegister.class);

        // Remove

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Remove Item")
                .desc("# Remove item from the slot")
                .example("[Object].removeItem{[number]};")
                .usage(new String[]{
                        "%string%.Inventory.removeItem{%number%}[;]"
                }), RemoveItem.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Remove Lore")
                .desc("# Remove lore from the slot")
                .example("[Object].removeLore{[number]};")
                .usage(new String[]{
                        "%string%.Inventory.removeLore{%number%}[;]"
                }), RemoveLore.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Remove Command")
                .desc("# Remove command from the slot")
                .example("[Object].removeCommand{[number]};")
                .usage(new String[]{
                        "%string%.Inventory.removeCommand{%number%}[;]"
                }), RemoveCommand.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Inventory")
                .name("Remove Executor")
                .desc("# Remove executor from the slot")
                .example("[Object].removeExecutor{[number]};")
                .usage(new String[]{
                        "%string%.Inventory.removeExecutor{%number%}[;]"
                }), RemoveExecutor.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Name")
                        .desc("# Get name")
                        .example("[Object].getName{};")
                        .usage(new String[]{
                                "%string%.Inventory.getName{}[;]"
                        })
                , ExpressionName.class, String.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Row")
                        .desc("# Get row")
                        .example("[Object].getRow{};")
                        .usage(new String[]{
                                "%string%.Inventory.getRow{}[;]"
                        })
                , ExpressionRow.class, Integer.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Item")
                        .desc("# Get item by slot")
                        .example("[Object].getItem{[number]};")
                        .usage(new String[]{
                                "%string%.Inventory.getItem{%number%}[;]"
                        })
                , ExpressionItem.class, ItemType.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Lore")
                        .desc("# Get lore by slot")
                        .example("[Object].getLore{[number]};")
                        .usage(new String[]{
                                "%string%.Inventory.getLore{%number%}[;]"
                        })
                , ExpressionLore.class, String.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Command")
                        .desc("# Get command by slot")
                        .example("[Object].getCommand{[number]};")
                        .usage(new String[]{
                                "%string%.Inventory.getCommand{%number%}[;]"
                        })
                , ExpressionCommand.class, String.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Cancelled")
                        .desc("# Get cancelled by slot")
                        .example("[Object].getCancelled{[number]};")
                        .usage(new String[]{
                                "%string%.Inventory.getCancelled{%number%}[;]"
                        })
                , ExpressionCancelled.class, Boolean.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Executor")
                        .desc("# Get executor by slot")
                        .example("[Object].getExecutor{[number]};")
                        .usage(new String[]{
                                "%string%.Inventory.getExecutor{%number%}[;]"
                        })
                , ExpressionExecutor.class, String.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("Get Closed")
                        .desc("# Get closed by slot")
                        .example("[Object].getClosed{[number]};")
                        .usage(new String[]{
                                "%string%.Inventory.getClosed{%number%}[;]"
                        })
                , ExpressionClosed.class, Boolean.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Inventory")
                        .name("First Empty")
                        .desc("# Get first empty slot")
                        .example("[Object].getFirstEmpty{};")
                        .usage(new String[]{
                                "%string%.Inventory.getFirstEmpty{}[;]"
                        })
                , ExpressionFirstEmpty.class, Integer.class);
    }
}
