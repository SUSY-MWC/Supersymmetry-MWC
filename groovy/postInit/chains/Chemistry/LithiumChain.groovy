import static globals.Globals.*
import static globals.SinteringGlobals.*

BR = recipemap('batch_reactor')
FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
DISTILLATION_TOWER = recipemap('distillation_tower')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
CENTRIFUGE = recipemap('centrifuge')
AUTOCLAVE = recipemap('autoclave')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
FLOTATION = recipemap('froth_flotation')
CRYSTALLIZER = recipemap('crystallizer')
SINTERING_RECIPES = recipemap("sintering_oven")
DRYER = recipemap("dryer")
MACERATOR = recipemap("macerator")

//UNIVERSAL
FLOTATION.recipeBuilder()
        .inputs(metaitem('dustImpureSpodumene') * 8)
        .notConsumable(fluid('alkaline_sodium_oleate_solution') * 1000)
        .outputs(metaitem('dustSpodumene') * 16)
        .outputs(metaitem('dustPegmatiteTailings') * 3)
        .EUt(30)
        .duration(100)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustSpodumene') * 10)
        .outputs(metaitem('dustBetaSpodumene') * 8)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustPetalite') * 1)
        .outputs(metaitem('dustRoastedPetalite') * 12)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

FLUIDIZEDBR.recipeBuilder()
        .inputs(metaitem('dustSpodumene') * 10)
        .outputs(metaitem('dustBetaSpodumene') * 10)
        .EUt(120)
        .duration(40)
        .buildAndRegister()

FLUIDIZEDBR.recipeBuilder()
        .inputs(metaitem('dustPetalite') * 1)
        .outputs(metaitem('dustRoastedPetalite') * 16)
        .EUt(160)
        .duration(40)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustRoastedPetalite') * 16)
        .outputs(metaitem('dustBetaSpodumene') * 10)
        .outputs(metaitem('dustSiliconDioxide') * 6)
        .EUt(30)
        .duration(40)
        .buildAndRegister()

//ACID DIGESTION (90%)
BR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 2000)
        .inputs(metaitem('dustBetaSpodumene') * 20)
        .fluidOutputs(fluid('impure_lithium_sulfate_solution') * 2000)
        .outputs(metaitem('dustAluminiumSilicate') * 8)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

//ALUMINIUM SILICATE PROCESSING
AUTOCLAVE.recipeBuilder()
        .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
        .inputs(metaitem('dustAluminiumSilicate') * 8)
        .fluidOutputs(fluid('sodium_silicate_solution') * 1000)
        .outputs(metaitem('dustAlumina') * 5)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('sodium_silicate_solution') * 1000)
        .fluidInputs(fluid('hydrogen_chloride') * 2000)
        .outputs(metaitem('dustWetSilicaGel') * 3)
        .fluidOutputs(fluid('salt_water') * 2000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

DRYER.recipeBuilder()
        .inputs(metaitem('dustWetSilicaGel'))
        .outputs(metaitem('dustSilicaGel'))
        .EUt(30)
        .duration(100)
        .buildAndRegister()

MACERATOR.recipeBuilder()
        .inputs(metaitem('dustSilicaGel'))
        .outputs(metaitem('dustSiliconDioxide'))
        .EUt(30)
        .duration(80)
        .buildAndRegister()

//IMPURITY PRECIPITATION
BR.recipeBuilder()
        .inputs(metaitem('dustSodiumHydroxide'))
        .fluidInputs(fluid('impure_lithium_sulfate_solution') * 1000)
        .chancedOutput(metaitem('dustAluminiumHydroxide'), 1111, 0)
        .chancedOutput(metaitem('dustIronIiiHydroxide'), 1111, 0)
        .chancedOutput(metaitem('dustMagnesiumHydroxide'), 1667, 0)
        .fluidOutputs(fluid('lithium_sulfate_solution') * 900)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('lithium_sulfate_solution') * 1000)
        .inputs(metaitem('dustSodaAsh') * 6)
        .outputs(metaitem('dustLithiumCarbonate') * 6)
        .fluidOutputs(fluid('sodium_sulfate_solution') * 1000)
        .duration(180)
        .EUt(200)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .inputs(metaitem('dustLithiumCarbonate') * 6)
        .outputs(metaitem('dustLithiumChloride') * 4)
        .fluidOutputs(fluid('steam') * 3000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .duration(180)
        .EUt(200)
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('graphite_electrode'))
        .notConsumable(metaitem('stickSteel'))
        .notConsumable(fluid('rock_salt') * 358)
        .fluidInputs(fluid('lithium_chloride') * 288)
        .fluidOutputs(fluid('chlorine') * 1000)
        .outputs(metaitem('dustLithium'))
        .EUt(120)
        .duration(180)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 1000)
        .inputs(metaitem('dustAmblygonite') * 8)
        .outputs(metaitem('dustAluminiumPhosphate') * 6)
        .fluidOutputs(fluid('amblygonite_leach') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('amblygonite_leach') * 2000)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .outputs(metaitem('dustLithiumSulfate') * 7)
        .fluidOutputs(fluid('dilute_hydrofluoric_acid') * 2000)
        .duration(60)
        .EUt(200)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('dilute_hydrofluoric_acid') * 2000)
        .fluidOutputs(fluid('hydrofluoric_acid') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustLithiumSulfate') * 7)
        .fluidInputs(fluid('soda_ash_solution') * 1000)
        .outputs(metaitem('dustLithiumCarbonate') * 6)
        .fluidOutputs(fluid('sodium_sulfate_solution') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustAluminiumPhosphate') * 6)
        .fluidInputs(fluid('hydrogen_chloride') * 3000)
        .outputs(metaitem('dustAluminiumTrichloride') * 3)
        .fluidOutputs(fluid('phosphoric_acid') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustAluminiumTrichloride') * 3)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .outputs(metaitem('dustAluminiumHydroxide') * 7)
        .fluidOutputs(fluid('salt_water') * 3000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

for (fuel in sintering_fuels) {
    if (fuel.isPlasma) {
        SINTERING_RECIPES.recipeBuilder()
                .inputs(metaitem('dustLepidolite') * 20)
                .inputs(metaitem('dustQuicklime') * 4)
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .outputs(metaitem('dustRoastedLepidolite') * 20)
                .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                .duration(fuel.duration)
                .EUt(Globals.voltAmps[3])
                .buildAndRegister()

    } else {
        for (comburent in sintering_comburents) {
            SINTERING_RECIPES.recipeBuilder()
                    .inputs(metaitem('dustLepidolite') * 20)
                    .inputs(metaitem('dustQuicklime') * 4)
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('dustRoastedLepidolite') * 20)
                    .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(Globals.voltAmps[1])
                    .buildAndRegister()
        }
    }
}

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('dustRoastedLepidolite') * 20)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('lepidolite_leach') * 1000)
        .outputs(metaitem('dustAlkaliAlumMix') * 4)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('dustQuicklime') * 2)
        .fluidInputs(fluid('lepidolite_leach') * 1000)
        .outputs(metaitem('dustCalciumSulfate') * 6)
        .fluidOutputs(fluid('neutralized_lepidolite_leach') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .notConsumable(metaitem('dustTinyAluminiumSulfate'))
        .fluidInputs(fluid('neutralized_lepidolite_leach') * 1000)
        .outputs(metaitem('dustAluminiumSulfate') * 17)
        .fluidOutputs(fluid('aluminium_free_lepidolite_leach') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .inputs(metaitem('dustSodiumBicarbonate') * 6)
        .fluidOutputs(fluid('sodium_bicarbonate_solution') * 1000)
        .EUt(30)
        .duration(80)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustAluminiumSulfate') * 17)
        .fluidInputs(fluid('sodium_bicarbonate_solution') * 6000)
        .outputs(metaitem('dustAluminiumHydroxide') * 14)
        .fluidOutputs(fluid('dilute_sodium_sulfate_solution') * 6000)
        .fluidOutputs(fluid('carbon_dioxide') * 6000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('dilute_sodium_sulfate_solution') * 2000)
        .fluidOutputs(fluid('water') * 2000)
        .outputs(metaitem('dustSodiumSulfate') * 7)
        .duration(30)
        .EUt(200)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('dustSodaAsh') * 6)
        .fluidInputs(fluid('aluminium_free_lepidolite_leach') * 1000)
        .outputs(metaitem('dustLithiumCarbonate') * 6)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(120)
        .EUt(200)
        .buildAndRegister()